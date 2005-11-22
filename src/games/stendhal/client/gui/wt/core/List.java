/* $Id$ */
/***************************************************************************
 *                      (C) Copyright 2005 - Marauroa                      *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.client.gui.wt.core;


/**
 * A list similar to a context menu.
 * 
 * @author mtotz
 */
public class List extends Panel implements ClickListener
{
  private static final int BUTTON_HEIGHT = 20;

  /**
   * Creates a new List.
   * 
   * @param name Name of the list. This is also the title.
   * @param items items to show
   * @param x x-pos
   * @param y y-pos
   * @param width width
   * @param maxHeight max height (height is dynamically calculated from the
   *         items)
   */
  public List(String name, String[] items, int x, int y, int width, int maxHeight)
  {
    super(name,x,y,width,10);
    
    setTitleBar(true);
    setFrame(true);
    setCloseable(true);
    setMinimizeable(false);
    setMoveable(false);
    
    this.resizeToFitClientArea(width,(items.length*BUTTON_HEIGHT < maxHeight) ? (items.length*BUTTON_HEIGHT) : maxHeight);

    int clientWidth = getClientWidth();
    
    for (int i = 0; i < items.length; i++)
    {
      String item = items[i];
      Button button = new Button(item,clientWidth,BUTTON_HEIGHT,item); 
      button.moveTo(0,i*BUTTON_HEIGHT);
      button.registerClickListener(this);
      addChild(button);
    }
  }

  /** an action has been chosen */
  public void onClick(String name, boolean pressed)
  {
    // tell all listeners what happend
    notifyClickListeners(name,pressed);
    // close ourself
    close();
  }
}

