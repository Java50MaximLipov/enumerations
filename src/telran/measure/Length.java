package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	@Override
	public int compareTo(Length obj) {
		return Float.compare(amount * lengthUnit.value, obj.amount * obj.lengthUnit.value);
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Length)) {
			return false;
		}
		return compareTo((Length) obj) == 0;
	}

	public Length convert(LengthUnit lengthUnit) {
		return new Length(getAmount() * this.lengthUnit.value / lengthUnit.value, lengthUnit);
	}

	public String toString() {
		return String.format("%.1f", amount) + lengthUnit.name();
	}

}
