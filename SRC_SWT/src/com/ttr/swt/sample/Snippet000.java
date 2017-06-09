package com.ttr.swt.sample;

//Send questions, comments, bug reports, etc. to the authors:

//Rob Warner (rwarner@interspatial.com)
//Robert Harris (rbrt_harris@yahoo.com)

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This class demonstrates Buttons
 */

public class Snippet000 {
	public static Button bpush1;
	public static Button bcheck1;
	public static Button bcheck2;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(3, true));

		// Create three push buttons
		bpush1 = new Button(shell, SWT.PUSH);
		bpush1.setText("Push 1");

		new Button(shell, SWT.PUSH).setText("Push 2");
		new Button(shell, SWT.PUSH).setText("Push 3");

		// Create three checkboxes
		bcheck1 = new Button(shell, SWT.CHECK);
		bcheck1.setText("Checkbox 1");
		bcheck1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Snippet000.doThat();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		bcheck2 = new Button(shell, SWT.CHECK);
		bcheck2.setText("Checkbox 2");
		//bcheck2.setGrayed(true);
		bcheck2.setSelection(true);
		bcheck2.setEnabled(false);

		new Button(shell, SWT.CHECK).setText("Checkbox 3");

		// Create three toggle buttons
		new Button(shell, SWT.TOGGLE).setText("Toggle 1");
		new Button(shell, SWT.TOGGLE).setText("Toggle 2");
		new Button(shell, SWT.TOGGLE).setText("Toggle 3");

		// Create three radio buttons
		new Button(shell, SWT.RADIO).setText("Radio 1");
		new Button(shell, SWT.RADIO).setText("Radio 2");
		new Button(shell, SWT.RADIO).setText("Radio 3");

		// Create three flat buttons
		new Button(shell, SWT.FLAT).setText("Flat 1");
		new Button(shell, SWT.FLAT).setText("Flat 2");
		new Button(shell, SWT.FLAT).setText("Flat 3");

		// Create three arrow buttons
		new Button(shell, SWT.ARROW);
		new Button(shell, SWT.ARROW | SWT.LEFT);
		new Button(shell, SWT.ARROW | SWT.DOWN);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	public static void doThat(){

		if (bcheck1.getSelection())
			System.out.println("is is true");
		else
			System.out.println("is is false");

	}
}