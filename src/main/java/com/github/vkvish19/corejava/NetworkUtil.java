package com.github.vkvish19.corejava;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NetworkUtil
{
    public static void main(String[] args) throws UnknownHostException
    {
        System.out.println("getHostnamesAndIPv4s() = " + getHostnamesAndIPv4s());
        System.out.println("*****************************");
        InetAddress [] addrs = InetAddress.getAllByName(args[0]);
        for (InetAddress addr : addrs)
        {
            System.out.println(addr);
        }
    }
    
    private static final String COMPONENT_NAME = NetworkUtil.class.getSimpleName();
    
    public static Set<String> getHostnamesAndIPv4s()
    {
        Set<String> hostnamesAndIPv4s = new HashSet<>();
        String hostname = getHostName();
        System.out.println("hostname = " + hostname);
        hostnamesAndIPv4s.add(hostname);
        try
        {
            Enumeration<NetworkInterface> networkInterfaceEnum = getNetworkInterfaces();
            
            if(networkInterfaceEnum != null)
            {
                while(networkInterfaceEnum.hasMoreElements())
                {
                    NetworkInterface nwIf = networkInterfaceEnum.nextElement();
                    String nwIfName = nwIf.getName();
                    // loopback, docker and bridge address to be ignored
                    if(nwIfName != null
                            && (nwIfName.equalsIgnoreCase("lo") || nwIfName.toLowerCase().startsWith("docker") || nwIfName.toLowerCase().startsWith("br-")))
                    {
                        continue;
                    }
                    try
                    {
                        if(!nwIf.isUp() || nwIf.isLoopback())
                        {
                            continue;
                        }
                        
                        Enumeration<InetAddress> enumInetAddresses = nwIf.getInetAddresses();
                        while(enumInetAddresses.hasMoreElements())
                        {
                            InetAddress inetAddress = enumInetAddresses.nextElement();
                            String fqdn = inetAddress.getCanonicalHostName();
                            if(fqdn != null && !isIPv6Address(fqdn))
                            {
                                hostnamesAndIPv4s.add(fqdn.toLowerCase());
                            }
                            
                            String ipAddress = inetAddress.getHostAddress();
                            if(ipAddress != null && !isIPv6Address(ipAddress))
                            {
                                hostnamesAndIPv4s.add(ipAddress);
                            }
                        }
                    }
                    catch(SocketException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return hostnamesAndIPv4s;
    }
    
    public static boolean isIPv6Address(String address)
    {
        return address != null && address.contains(":");
    }
    
    public static Enumeration<NetworkInterface> getNetworkInterfaces()
    {
        Enumeration<NetworkInterface> networkInterfaceEnum = null;
        try
        {
            networkInterfaceEnum = NetworkInterface.getNetworkInterfaces();
        }
        catch(SocketException e)
        {
            e.printStackTrace();
        }
        return networkInterfaceEnum;
    }
    
    public static boolean isIPv4Address(String address)
    {
        StringTokenizer tokenizer = new StringTokenizer(address, ".", false);
        try
        {
            if(tokenizer.countTokens() == 4)
            {
                while(tokenizer.hasMoreTokens())
                {
                    String token = tokenizer.nextToken();
                    int i = Integer.parseInt(token);
                    if(i < 0 || i > 255)
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        catch(NumberFormatException e)
        {
            // do nothing
        }
        return false;
    }
    
    public static String getHostName()
    {
        String hostname;
        
        try
        {
            hostname = InetAddress.getLocalHost().getCanonicalHostName();
            
            if(!hostname.contains(".") || isDockerInternalHostname(hostname))
            {
                System.out.println(
                        "Canonical hostname does not appear to be fully qualified, attempting to use IPAddress");
                // shortname (contains no .) use the IP address as host name
                
                String hostMachineName = InetAddress.getLocalHost().getHostName().toLowerCase();
                Set<String> hostnames = getHostNames();
                boolean isUpdated = false;
                for(String dns : hostnames)
                {
                    //Look for dns which starts with machine hostname.
                    if(dns.toLowerCase().startsWith(hostMachineName))
                    {
                        hostname = dns;
                        isUpdated = true;
                        break;
                    }
                }
                
                if(!isUpdated)
                    hostname = InetAddress.getLocalHost().getHostAddress();
            }
        }
        catch(UnknownHostException e)
        {
            try
            {
                hostname = InetAddress.getLocalHost().getHostAddress();
            }
            catch(UnknownHostException e1)
            {
                hostname = System.getProperty("HOSTNAME", "UNSET");
                if(hostname.equals("UNSET"))
                {
                    hostname = System.getProperty("COMPUTERNAME", "UNSET");
                    if(hostname.equals("UNSET"))
                    {
                        System.out.println("Unable to determine computer name.  Please set the HOSTNAME or COMPUTERNAME environment variable and retry" + e);
                        hostname = "localhost";
                    }
                }
                
            }
        }
        return hostname;
    }
    
    /**
     * Get all the hostnames for this device
     * @return
     */
    public static Set<String> getHostNames()
    {
        Set<String> hostNames = new HashSet<>(0);
        
        try
        {
            InetAddress localHost = InetAddress.getLocalHost();
            if(localHost != null)
            {
                String fqdn = localHost.getCanonicalHostName();
                
                if(fqdn != null && (!fqdn.contains(":")) && !isIPv4Address(fqdn) && !isDockerInternalHostname(fqdn))
                {
                    hostNames.add(fqdn);
                }
            }
            
            Enumeration<NetworkInterface> en = getNetworkInterfaces();
            
            if(en != null)
            {
                for(int networkInterfaceNumber = 0; en.hasMoreElements(); networkInterfaceNumber++)
                {
                    try
                    {
                        NetworkInterface intf = en.nextElement();
                        
                        if(!intf.isUp() || intf.isLoopback())
                        {
                            continue;
                        }
                        
                        Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                        for(int addressNumber = 0; enumIpAddr.hasMoreElements(); addressNumber++)
                        {
                            InetAddress ipAddr = enumIpAddr.nextElement();
                            String fqdn = ipAddr.getCanonicalHostName();
                            if(fqdn != null && (!fqdn.contains(":")) && !isIPv4Address(fqdn) && !isDockerInternalHostname(fqdn))
                            {
                                hostNames.add(fqdn);
                            }
                        }
                        
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(hostNames.isEmpty())
        {
            try
            {
                String name = InetAddress.getLocalHost().getHostAddress();
                if(name != null)
                    hostNames.add(name);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        
        return hostNames;
    }
    
    private static boolean isDockerInternalHostname(String hostname)
    {
        return "host.docker.internal".equalsIgnoreCase(hostname);
    }
}
