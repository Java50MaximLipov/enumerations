package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), M(1000), KM(1_000_000);

	float value;

	LengthUnit(float nMl) {
		value = nMl;
	}

	float getValue() {
		return value;
	}

	public Length between(Length length2, Length length1) {
		Length convValue1 = length1.convert(this);
		Length convValue2 = length2.convert(this);
		float diff = Math.abs(convValue2.getAmount() - convValue1.getAmount());
		return new Length(diff, this);
	}
}
