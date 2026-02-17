package edu.uoc.pac2;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Represents a firewall rule that controls network traffic based on various parameters.
 * A firewall rule can be used to allow or deny traffic based on source IP, destination IP,
 * protocol, port, and other criteria.
 *
 * @author acarbonellfus
 * @version final
 */
public class FirewallRule {

    /**
     * Name of the firewall rule
     */
    private String ruleName;

    /**
     * Source IP address in IPv4 format
     */
    private String sourceIP;

    /**
     * Destination IP address in IPv4 format
     */
    private String destinationIP;

    /**
     * Network protocol (TCP, UDP, or ICMP)
     */
    private String protocol;

    /**
     * Port number (1-65535)
     */
    private int port;

    /**
     * Action to take (ALLOW or DENY)
     */
    private String action;

    /**
     * Indicates whether the rule is enabled or disabled
     */
    private boolean isEnabled;

    /**
     * Date when the rule was created
     */
    private LocalDate creationDate;

    /**
     * Date until which the rule is valid
     */
    private LocalDate validUntil;

    /**
     * Minimum valid port number
     */
    private static int minPort = 1;

    /**
     * Maximum valid port number
     */
    private static int maxPort = 65535;

    /**
     * FTP protocol port number
     */
    private static int ftpPort = 21;

    /**
     * SSH protocol port number
     */
    private static int sshPort = 22;

    /**
     * HTTP protocol port number
     */
    private static int httpPort = 80;

    /**
     * HTTPS protocol port number
     */
    private static int httpsPort = 443;

    /**
     * Array of valid protocol names
     */
    private static String[] validProtocols = {"TCP", "UDP", "ICMP"};

    /**
     * Array of valid action types
     */
    private static String[] validActions = {"ALLOW", "DENY"};

    /**
     * Constructs a new FirewallRule with the specified parameters.
     * If any parameter is invalid, default values are used and the rule is still created.
     *
     * @param ruleName Name of the rule (cannot be null or empty)
     * @param sourceIP Source IP address in IPv4 format
     * @param destinationIP Destination IP address in IPv4 format
     * @param protocol Network protocol (TCP, UDP, or ICMP)
     * @param port Port number (1-65535)
     * @param action Action to take (ALLOW or DENY)
     * @param isEnabled Whether the rule is enabled
     * @param creationDate Date when the rule was created
     * @param validUntil Date until which the rule is valid
     * @throws Exception if any validation fails during construction
     */
    public FirewallRule(String ruleName, String sourceIP, String destinationIP,
                        String protocol, int port, String action, boolean isEnabled,
                        LocalDate creationDate, LocalDate validUntil) throws Exception {
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

    /**
     * Gets the name of the rule.
     *
     * @return the rule name
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Gets the source IP address.
     *
     * @return the source IP address
     */
    public String getSourceIP() {
        return sourceIP;
    }

    /**
     * Gets the destination IP address.
     *
     * @return the destination IP address
     */
    public String getDestinationIP() {
        return destinationIP;
    }

    /**
     * Gets the network protocol.
     *
     * @return the protocol (TCP, UDP, or ICMP)
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Gets the port number.
     *
     * @return the port number
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets the action to take.
     *
     * @return the action (ALLOW or DENY)
     */
    public String getAction() {
        return action;
    }

    /**
     * Checks if the rule is enabled.
     *
     * @return true if the rule is enabled, false otherwise
     */
    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * Gets the creation date of the rule.
     *
     * @return the creation date
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Gets the date until which the rule is valid.
     *
     * @return the valid until date
     */
    public LocalDate getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the name of the rule.
     * The name cannot be null, empty, or contain only whitespace.
     * Leading and trailing whitespace is trimmed.
     *
     * @param ruleName the new rule name
     * @throws Exception if the rule name is null, empty, or contains only whitespace
     */
    public void setRuleName(String ruleName) throws Exception {
        if (ruleName == null || ruleName.trim().isEmpty()) {
            throw new Exception("[ERROR] Rule name cannot be null, empty or contain only whitespace.");
        }
        this.ruleName = ruleName.trim();
    }

    /**
     * Sets the source IP address.
     * The IP address must be a valid IPv4 address.
     *
     * @param sourceIP the new source IP address
     * @throws Exception if the IP address is not valid
     */
    public void setSourceIP(String sourceIP) throws Exception {
        if (!isValidIP(sourceIP)) {
            throw new Exception("[ERROR] Source IP must be a valid IPv4 address.");
        }
        this.sourceIP = sourceIP;
    }

    /**
     * Sets the destination IP address.
     * The IP address must be a valid IPv4 address.
     *
     * @param destinationIP the new destination IP address
     * @throws Exception if the IP address is not valid
     */
    public void setDestinationIP(String destinationIP) throws Exception {
        if (!isValidIP(destinationIP)) {
            throw new Exception("[ERROR] Destination IP must be a valid IPv4 address.");
        }
        this.destinationIP = destinationIP;
    }

    /**
     * Sets the network protocol.
     * The protocol must be one of: TCP, UDP, or ICMP (case insensitive).
     * The value is stored in uppercase.
     *
     * @param protocol the new protocol
     * @throws Exception if the protocol is not valid
     */
    public void setProtocol(String protocol) throws Exception {
        if (!isValidProtocol(protocol)) {
            throw new Exception("[ERROR] Protocol must be one of: TCP, UDP, ICMP.");
        }
        this.protocol = protocol.toUpperCase();
    }

    /**
     * Sets the port number.
     * The port must be between 1 and 65535 (inclusive).
     *
     * @param port the new port number
     * @throws Exception if the port is not within the valid range
     */
    public void setPort(int port) throws Exception {
        if (port < minPort || port > maxPort) {
            throw new Exception("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.");
        }
        this.port = port;
    }

    /**
     * Sets the action to take.
     * The action must be either ALLOW or DENY (case insensitive).
     * The value is stored in uppercase.
     *
     * @param action the new action
     * @throws Exception if the action is not valid
     */
    public void setAction(String action) throws Exception {
        if (!isValidAction(action)) {
            throw new Exception("[ERROR] Action must be one of: ALLOW, DENY.");
        }
        this.action = action.toUpperCase();
    }

    /**
     * Sets whether the rule is enabled.
     *
     * @param isEnabled true to enable the rule, false to disable it
     */
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Sets the creation date of the rule.
     * The date cannot be null or in the future.
     *
     * @param creationDate the new creation date
     * @throws Exception if the date is null or in the future
     */
    public void setCreationDate(LocalDate creationDate) throws Exception {
        if (creationDate == null || creationDate.isAfter(LocalDate.now())) {
            throw new Exception("[ERROR] Creation date cannot be null or in the future.");
        }
        this.creationDate = creationDate;
    }

    /**
     * Sets the date until which the rule is valid.
     * The date cannot be null or before the creation date.
     *
     * @param validUntil the new valid until date
     * @throws Exception if the date is null or before the creation date
     */
    public void setValidUntil(LocalDate validUntil) throws Exception {
        if (validUntil == null || this.creationDate == null || validUntil.isBefore(this.creationDate)) {
            throw new Exception("[ERROR] Valid until date cannot be null or before the creation date.");
        }
        this.validUntil = validUntil;
    }

    /**
     * Validates an IPv4 address.
     * An IP address is valid if it consists of four octets (0-999) separated by dots.
     * Note: This validation allows values greater than 255.
     *
     * @param ip the IP address to validate
     * @return true if the IP address is valid, false otherwise
     */
    private boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String ipRegex = "^(([0-9]|[1-9][0-9]|[1-9][0-9]{2})\\.){3}([0-9]|[1-9][0-9]|[1-9][0-9]{2})$";
        return Pattern.matches(ipRegex, ip);
    }

    /**
     * Validates a network protocol.
     * A protocol is valid if it matches one of the valid protocols (TCP, UDP, ICMP).
     * The comparison is case insensitive.
     *
     * @param protocol the protocol to validate
     * @return true if the protocol is valid, false otherwise
     */
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

    /**
     * Validates an action.
     * An action is valid if it matches one of the valid actions (ALLOW, DENY).
     * The comparison is case insensitive.
     *
     * @param action the action to validate
     * @return true if the action is valid, false otherwise
     */
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

    /**
     * Checks if the rule has not expired.
     * A rule is not expired if the current date is before or equal to the valid until date.
     *
     * @return true if the rule is not expired, false otherwise
     */
    public boolean isNotExpired() {
        return LocalDate.now().isBefore(validUntil) || LocalDate.now().isEqual(validUntil);
    }

    /**
     * Checks if the rule applies to a critical port.
     * Critical ports are: FTP (21), SSH (22), HTTP (80), and HTTPS (443).
     *
     * @return true if the rule applies to a critical port, false otherwise
     */
    public boolean isCriticalPort() {
        return port == ftpPort || port == sshPort || port == httpPort || port == httpsPort;
    }

    /**
     * Checks if this is a critical rule.
     * A rule is critical if it is enabled, not expired, and applies to a critical port.
     *
     * @return true if the rule is critical, false otherwise
     */
    public boolean isCriticalRule() {
        return isEnabled && isNotExpired() && isCriticalPort();
    }

    /**
     * Checks if the rule is applicable to the given traffic parameters.
     * A rule is applicable if it is enabled, not expired, and all parameters match.
     *
     * @param sourceIP the source IP address to check
     * @param destinationIP the destination IP address to check
     * @param protocol the protocol to check
     * @param port the port to check
     * @return true if the rule is applicable, false otherwise
     */
    public boolean isApplicable(String sourceIP, String destinationIP, String protocol, int port) {
        return isEnabled &&
                isNotExpired() &&
                this.sourceIP.equals(sourceIP) &&
                this.destinationIP.equals(destinationIP) &&
                this.protocol.equalsIgnoreCase(protocol) &&
                this.port == port;
    }

    /**
     * Counts the number of matching rules for a specific action.
     * This method checks multiple traffic entries and counts how many match
     * this rule with the specified action.
     *
     * @param sourceIP array of source IP addresses
     * @param destinationIP array of destination IP addresses
     * @param protocol array of protocols
     * @param port array of ports
     * @param action the action to match (ALLOW or DENY)
     * @return the number of matching rules, or 0 if inputs are invalid
     */
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

    /**
     * Validates the input arrays for traffic calculation methods.
     * Arrays are valid if they are not null, have the same length,
     * and all elements are valid (valid IPs, valid protocols, valid ports).
     *
     * @param sourceIP array of source IP addresses
     * @param destinationIP array of destination IP addresses
     * @param protocol array of protocols
     * @param port array of ports
     * @return true if all inputs are valid, false otherwise
     */
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

    /**
     * Calculates the percentage of allowed traffic.
     * This method analyzes multiple traffic entries and calculates what percentage
     * would be allowed by this rule if its action is ALLOW.
     *
     * @param sourceIP array of source IP addresses
     * @param destinationIP array of destination IP addresses
     * @param protocol array of protocols
     * @param port array of ports
     * @return the percentage of allowed traffic (0-100), or 0.0 if arrays are empty
     * @throws Exception if the input data is invalid
     */
    public double calculateAllowedTrafficPct(String[] sourceIP, String[] destinationIP,
                                             String[] protocol, int[] port) throws Exception {
        if (!areInputsValid(sourceIP, destinationIP, protocol, port)) {
            throw new Exception("[ERROR] Invalid input data for traffic percentage calculation.");
        }

        if (sourceIP.length == 0) {
            return 0.0;
        }

        int allowedCount = countMatchingRulesByAction(sourceIP, destinationIP, protocol, port, "ALLOW");
        return (double) allowedCount / sourceIP.length * 100;
    }

    /**
     * Calculates the percentage of denied traffic.
     * This method analyzes multiple traffic entries and calculates what percentage
     * would be denied by this rule if its action is DENY.
     *
     * @param sourceIP array of source IP addresses
     * @param destinationIP array of destination IP addresses
     * @param protocol array of protocols
     * @param port array of ports
     * @return the percentage of denied traffic (0-100), or 0.0 if arrays are empty
     * @throws Exception if the input data is invalid
     */
    public double calculateDeniedTrafficPct(String[] sourceIP, String[] destinationIP,
                                            String[] protocol, int[] port) throws Exception {
        if (!areInputsValid(sourceIP, destinationIP, protocol, port)) {
            throw new Exception("[ERROR] Invalid input data for traffic percentage calculation.");
        }

        if (sourceIP.length == 0) {
            return 0.0;
        }

        int deniedCount = countMatchingRulesByAction(sourceIP, destinationIP, protocol, port, "DENY");
        return (double) deniedCount / sourceIP.length * 100;
    }
}