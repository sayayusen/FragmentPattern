package jp.eure.android.sample.FragmentPattern.util;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
import android.util.Log;

public class DLog {
	public static void d(String msg) {

		if (Constants.IS_PRODUCT) {
			return;
		}
		Log.d(_createTag(), msg);
	}

	public static void v(String msg) {

		if (Constants.IS_PRODUCT) {
			return;
		}
		Log.v(_createTag(), msg);
	}

	private static String _createTag() {
		StackTraceElement stack = Thread.currentThread().getStackTrace()[4];
		return stack.getClassName() + "_" + stack.getMethodName() + "(" + stack.getLineNumber() + ")";
	}
}
