package se.sigma.test.model;

public enum AnswerOption {
	ONE(1, "Stämmer inte alls"), TWO(2, "Stämmer delvis"), THREE(3,
			"Stämmer väl"), FOUR(4, "Stämmer mycket väl");

	private final int value;
	private final String description;

	private AnswerOption(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

}
