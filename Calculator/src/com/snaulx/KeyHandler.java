package com.snaulx;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.snaulx.CalcLogic.addToNumber;
import static com.snaulx.CalcLogic.removeLast;
import static com.snaulx.CalcLogic.addBinaryOperation;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        //parseKey(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        parseKey(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //parseKey(e.getKeyCode());
    }

    private void parseKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_0 -> addToNumber('0');
            case KeyEvent.VK_1 -> addToNumber('1');
            case KeyEvent.VK_2 -> addToNumber('2');
            case KeyEvent.VK_3 -> addToNumber('3');
            case KeyEvent.VK_4 -> addToNumber('4');
            case KeyEvent.VK_5 -> addToNumber('5');
            case KeyEvent.VK_6 -> addToNumber('6');
            case KeyEvent.VK_7 -> addToNumber('7');
            case KeyEvent.VK_8 -> addToNumber('8');
            case KeyEvent.VK_9 -> addToNumber('9');
            case KeyEvent.VK_ENTER, KeyEvent.VK_EQUALS -> Form.calculate();
            case KeyEvent.VK_BACK_SPACE -> removeLast();
            case KeyEvent.VK_PLUS, KeyEvent.VK_ADD -> addBinaryOperation(BinaryOperation.PLUS);
            case KeyEvent.VK_MINUS, KeyEvent.VK_SUBTRACT -> addBinaryOperation(BinaryOperation.MINUS);
            case KeyEvent.VK_MULTIPLY -> addBinaryOperation(BinaryOperation.STAR);
            case KeyEvent.VK_DIVIDE, KeyEvent.VK_SLASH -> addBinaryOperation(BinaryOperation.SLASH);
        }
    }
}
