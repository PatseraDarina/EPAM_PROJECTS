package ua.nure.patsera.Practice6.part1;

public class Word implements Comparable<Object>  {
	private String word;
	private Integer frequency;

	public Word(String word, Integer frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public Integer incrementFreq() {
		return this.frequency++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		Word wordObj = (Word) o;
		int result = frequency - wordObj.frequency;
		if (result != 0)
			 return result;

		result = word.compareTo(wordObj.word);
		return result;
	}

}
