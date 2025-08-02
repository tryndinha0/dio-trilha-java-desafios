package dio.util;

public final class BoardTemplate {
    private final String templateString;

    public BoardTemplate(String templateString) {
        this.templateString = templateString;
    }

    public String getTemplate() {
        return templateString;
    }

    // Se você quiser usar diretamente, pode sobrescrever toString()
    @Override
    public String toString() {
        return templateString;
    }
    // private BoardTemplate() {
    // }

    // public final static String BOARD_TEMPLATE =
    
}
