package com.ttr.swt.sample;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MyDialog extends Dialog {
	Object result;
		
	public MyDialog (Shell parent, int style) {
		super (parent, style);
	}
	public MyDialog (Shell parent) {
		this (parent, 0); // your default style bits go here (not the Shell's style bits)
	}
	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);

		MyDialog d = new MyDialog(shell);
		d.open();
	}
	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		//Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.SYSTEM_MODAL| SWT.ON_TOP);
		//Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL | SWT.ON_TOP);

		shell.forceActive();
		shell.forceFocus();
		GridLayout layout = new GridLayout();
		layout.numColumns=2;
		layout.makeColumnsEqualWidth=true;
		shell.setLayout(layout);

	    Button button1 = new Button(shell, SWT.PUSH);
	    button1.setText("button1");
	    
		Label label1 = new Label(shell, SWT.SHADOW_ETCHED_IN);
		label1.setText("Label1 in SHADOW_ETCHED_IN");

		Label label2 = new Label(shell, SWT.SHADOW_IN);
		label2.setText("Label2 in SHADOW_IN");

		Label label3 = new Label(shell, SWT.SHADOW_OUT);
		label3.setText("Label3 in SHADOW_OUT");

		Label label4 = new Label(shell, SWT.WRAP);
		label4.setText("Label4 in WRAP");
		
		shell.setText("Hello");
		// Your code goes here (widget creation, set result, etc).
		shell.open();
		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		return result;
	}
}