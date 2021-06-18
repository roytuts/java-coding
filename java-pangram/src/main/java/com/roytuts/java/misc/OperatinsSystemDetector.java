package com.roytuts.java.misc;

public class OperatinsSystemDetector {

	public static void main(String[] args) {
		System.out.println(isWindows());

		System.out.println(isUnix());

		System.out.println(isMac());

		System.out.println(isSolaris());
	}

	private static final String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Is run on windows os?
	 *
	 * @return is windows?
	 */
	public static boolean isWindows() {

		return (OS.contains("win"));

	}

	/**
	 * Is run on mac os?
	 *
	 * @return is mac?
	 */
	public static boolean isMac() {

		return (OS.contains("mac"));

	}

	/**
	 * Is run on unix os?
	 *
	 * @return is unix?
	 */
	public static boolean isUnix() {

		return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));

	}

	/**
	 * Is run on solaris os?
	 *
	 * @return is solaris?
	 */
	public static boolean isSolaris() {

		return (OS.contains("sunos"));

	}
}
