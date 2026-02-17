package edu.uoc.pac2;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class FirewallRule {
    private String ruleName;
    private String sourceIP;
    private String destinationIP;
    private String protocol;
    private int port;
    private String action;
    private boolean isEnabled;
    private LocalDate creationDate;
    private LocalDate validUntil;

    private static int minPort = 1;
    private static int maxPort = 65535;
    private static int ftpPort = 21;
    private static int sshPort = 22;
    private static int httpPort = 80;
    private static int httpsPort = 443;
    private static String[] validProtocols = {"TCP", "UDP", "ICMP"};
    private static String[] validActions = {"ALLOW", "DENY"};

    public FirewallRule(String ruleName, String sourceIP, String destinationIP,
                        String protocol, int port, String action, boolean isEnabled,
                        LocalDate creationDate, LocalDate validUntil) {
        this.ruleName = "New Rule";
        this.sourceIP = "0.0.0.0";
        this.destinationIP = "0.0.0.0";
        this.protocol = "TCP";
        this.port = 80;
        this.action = "DENY";
        this.isEnabled = false;

        setRuleName(ruleName);
        setSourceIP(sourceIP);
        setDestinationIP(destinationIP);
        setProtocol(protocol);
        setPort(port);
        setAction(action);
        setEnabled(isEnabled);
        setCreationDate(creationDate);
        setValidUntil(validUntil);

        if (this.creationDate == null) {
            this.creationDate = LocalDate.now();
        }
        if (this.validUntil == null) {
            this.validUntil = this.creationDate.plusDays(30);
        }
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

    public String getAction() {
        return action;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setRuleName(String ruleName) {
        if (ruleName == null || ruleName.trim().isEmpty()) {
            System.out.println("[ERROR] Rule name cannot be null, empty or contain only whitespace.");
            return;
        }
        this.ruleName = ruleName.trim();
    }

    public void setSourceIP(String sourceIP) {
        if (!isValidIP(sourceIP)) {
            System.out.println("[ERROR] Source IP must be a valid IPv4 address.");
            return;
        }
        this.sourceIP = sourceIP;
    }

    public void setDestinationIP(String destinationIP) {
        if (!isValidIP(destinationIP)) {
            System.out.println("[ERROR] Destination IP must be a valid IPv4 address.");
            return;
        }
        this.destinationIP = destinationIP;
    }

    public void setProtocol(String protocol) {
        if (!isValidProtocol(protocol)) {
            System.out.println("[ERROR] Protocol must be one of: TCP, UDP, ICMP.");
            return;
        }
        this.protocol = protocol.toUpperCase();
    }

    public void setPort(int port) {
        if (port < minPort || port > maxPort) {
            System.out.println("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.");
            return;
        }
        this.port = port;
    }

    public void setAction(String action) {
        if (!isValidAction(action)) {
            System.out.println("[ERROR] Action must be one of: ALLOW, DENY.");
            return;
        }
        this.action = action.toUpperCase();
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setCreationDate(LocalDate creationDate) {
        if (creationDate == null || creationDate.isAfter(LocalDate.now())) {
            System.out.println("[ERROR] Creation date cannot be null or in the future.");
            return;
        }
        this.creationDate = creationDate;
    }

    public void setValidUntil(LocalDate validUntil) {
        if (validUntil == null || this.creationDate == null || validUntil.isBefore(this.creationDate)) {
            System.out.println("[ERROR] Valid until date cannot be null or before the creation date.");
            return;
        }
        this.validUntil = validUntil;
    }

    private boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String ipRegex = "^(([0-9]|[1-9][0-9]|[1-9][0-9]{2})\\.){3}([0-9]|[1-9][0-9]|[1-9][0-9]{2})$";
        return Pattern.matches(ipRegex, ip);
    }

    private boolean isValidProtocol(String protocol) {
        if (protocol == null || protocol.isEmpty()) {
            return false;
        }

        for (String validProtocol : validProtocols) {
            if (validProtocol.equalsIgnoreCase(protocol)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidAction(String action) {
        if (action == null || action.isEmpty()) {
            return false;
        }

        for (String validAction : validActions) {
            if (validAction.equalsIgnoreCase(action)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNotExpired() {
        return LocalDate.now().isBefore(validUntil) || LocalDate.now().isEqual(validUntil);
    }

    public boolean isCriticalPort() {
        return port == ftpPort || port == sshPort || port == httpPort || port == httpsPort;
    }

    public boolean isCriticalRule() {
        return isEnabled && isNotExpired() && isCriticalPort();
    }

    public boolean isApplicable(String sourceIP, String destinationIP, String protocol, int port) {
        return isEnabled &&
                isNotExpired() &&
                this.sourceIP.equals(sourceIP) &&
                this.destinationIP.equals(destinationIP) &&
                this.protocol.equalsIgnoreCase(protocol) &&
                this.port == port;
    }

    public int countMatchingRulesByAction(String[] sourceIP, String[] destinationIP,
                                          String[] protocol, int[] port, String action) {
        if (!areInputsValid(sourceIP, destinationIP, protocol, port)) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < sourceIP.length; i++) {
            if (isApplicable(sourceIP[i], destinationIP[i], protocol[i], port[i]) &&
                    this.action.equalsIgnoreCase(action)) {
                count++;
            }
        }
        return count;
    }

    private boolean areInputsValid(String[] sourceIP, String[] destinationIP,
                                   String[] protocol, int[] port) {
        if (sourceIP == null || destinationIP == null || protocol == null || port == null) {
            return false;
        }

        int length = sourceIP.length;
        if (destinationIP.length != length || protocol.length != length || port.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!isValidIP(sourceIP[i]) || !isValidIP(destinationIP[i]) ||
                    !isValidProtocol(protocol[i]) || port[i] < minPort || port[i] > maxPort) {
                return false;
            }
        }

        return true;
    }

    public double calculateAllowedTrafficPct(String[] sourceIP, String[] destinationIP,
                                             String[] protocol, int[] port) {
        if (!areInputsValid(sourceIP, destinationIP, protocol, port)) {
            System.out.println("[ERROR] Invalid input data for traffic percentage calculation.");
            return 0.0;
        }

        int allowedCount = countMatchingRulesByAction(sourceIP, destinationIP, protocol, port, "ALLOW");
        return (double) allowedCount / sourceIP.length * 100;
    }

    public double calculateDeniedTrafficPct(String[] sourceIP, String[] destinationIP,
                                            String[] protocol, int[] port) {
        if (!areInputsValid(sourceIP, destinationIP, protocol, port)) {
            System.out.println("[ERROR] Invalid input data for traffic percentage calculation.");
            return 0.0;
        }

        int deniedCount = countMatchingRulesByAction(sourceIP, destinationIP, protocol, port, "DENY");
        return (double) deniedCount / sourceIP.length * 100;
    }
}