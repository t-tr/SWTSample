package com.ttr.swt.sample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/*
 * This example builds on HelloWorld2 and demonstrates how to resize the 
 * Label when the Shell resizes using a Listener mechanism.
 */
public class HelloWorld4 {

	String text = "Hello_world Hello_world Hello_world Hello_world Hello_world Hello_world!";

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new HelloWorld4().open(display);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public Shell open(Display display) {
		final Shell shell = new Shell(display);
		//final Label label = new Label(shell, SWT.CENTER);
		final Label label = new Label(shell, SWT.WRAP);
		//shell.setBounds(new Rectangle(0, 0, 400, 250));
		//label.setBounds(0,0,350,200);
		label.setText(text);
		//label.pack();

		shell.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				label.setBounds(shell.getClientArea());
			}
		});

		label.pack();
		shell.pack();
		shell.open();
		return shell;
	}
}