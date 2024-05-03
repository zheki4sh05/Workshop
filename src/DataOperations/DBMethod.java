package DataOperations;

public enum DBMethod {
    DEL("DEL"),
    ADD("ADD");
    public final String method;
    DBMethod(String method) {
        this.method = method;
    }
}
