package com.ttr.swt.sample;

/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
//package org.eclipse.swt.snippets;
/*
 * TextLayout example snippet: draw internationalized styled text on a shell
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class TextLayoutStyleColor {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		Font font1 = new Font(display, "Tahoma", 14, SWT.BOLD);
		Font font2 = new Font(display, "MS Mincho", 20, SWT.ITALIC);
		Font font3 = new Font(display, "Arabic Transparent", 18, SWT.NORMAL);

		Color blue = display.getSystemColor(SWT.COLOR_BLUE);
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color yellow = display.getSystemColor(SWT.COLOR_YELLOW);
		Color gray = display.getSystemColor(SWT.COLOR_GRAY);

		final TextLayout layout = new TextLayout(display);
		TextStyle style1 = new TextStyle(font1, yellow, blue);
		TextStyle style2 = new TextStyle(font2, green, null);
		TextStyle style3 = new TextStyle(font3, blue, gray);

		layout.setText("English 1234567890asdfasdfasdf");
		layout.setStyle(style1, 0, 6);
		layout.setStyle(style2, 8, 10);
		layout.setStyle(style3, 13, 21);

		shell.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				layout.draw(event.gc, 10, 10);
			}
		});
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		font1.dispose();
		font2.dispose();
		font3.dispose();
		layout.dispose();
		display.dispose();
	}
}