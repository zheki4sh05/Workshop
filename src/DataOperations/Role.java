package DataOperations;

public enum Role {
        ADMIN("ADMIN"),
        BLOCK("BLOCK"),
        CUSTOMER("CUSTOMER");
        public final String role;
        Role(String role) {
            this.role = role;
        }
}
