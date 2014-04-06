package com.eobiet.app.freakingmath;

import java.util.Random;

public class FreakingMath {

	final static int N = 20;

	final static int CONG = 0;

	final static int TRU = 1;

	final static int NHAN = 2;

	final static int CHIA = 3;

	private int left;

	private int right;

	private String result;

	private boolean exactly;

	private String opt;

	public FreakingMath() {
	}

	public FreakingMath(int left, int right, String opt) {
		super();
		this.left = left;
		this.right = right;
		this.opt = opt;
	}

	public static FreakingMath randomFreakingMath() {
		FreakingMath freakingMath = new FreakingMath();

		Random random = new Random();

		int left = random.nextInt(N);

		int right = random.nextInt(N);

		int intOpt = random.nextInt(4);

		String result = "fap";

		String opt = "+";

		switch (intOpt) {
		case CONG:
			opt = "+";
			int c = (left + right);
			result = String.valueOf(c);
			break;
		case TRU:
			opt = "-";
			int t = (left - right);
			result = String.valueOf(t);
			break;
		case NHAN:
			opt = "*";
			int n = (left * right);
			result = String.valueOf(n);
			break;
		case CHIA:
			opt = "/";
			if ((right == 0)) {
				result = "fap";
			} else {
				double ch = (left / (double) right);
				result = String.valueOf(ch);
			}

			break;
		}

		String[] resultArray = { result, String.valueOf(random.nextInt(20)),
				String.valueOf(random.nextInt(20)),
				String.valueOf(random.nextInt(20)),
				String.valueOf(random.nextInt(20)) };

		int posResultRandom = random.nextInt(4);

		if (posResultRandom == 0) {
			freakingMath.setExactly(true);
			freakingMath.setResult(resultArray[0]);
		} else {
			freakingMath.setExactly(false);
			freakingMath.setResult(resultArray[posResultRandom]);
		}

		freakingMath.setLeft(left);
		freakingMath.setRight(right);
		freakingMath.setOpt(opt);

		return freakingMath;
	}

	@Override
	public String toString() {
		return "FreakingMath [left=" + left + ", right=" + right + ", opt="
				+ opt + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isExactly() {
		return exactly;
	}

	public void setExactly(boolean exactly) {
		this.exactly = exactly;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

}
