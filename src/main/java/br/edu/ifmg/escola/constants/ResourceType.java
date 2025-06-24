package br.edu.ifmg.escola.constants;

public enum ResourceType {
    LESSON_ONLY("Lição"),
    LESSON_TASK("Tarefa"),
    FORUM("Fórum"),
    EXTERNAL_LINK("Link externo");

    private String description;

    private ResourceType (String description) {
        this.description = description;
    }
}
