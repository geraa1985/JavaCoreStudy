package Lesson_9;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
	private JRadioButton HvsPC;
	private JRadioButton HvsH;
	private ButtonGroup gameMode;
	private JSlider jSliderFieldX;
	private JSlider jSliderFieldY;
	private JSlider jSliderWin;

	private static final int MIN_FIELD_SIZE = 3;
	private static final int MAX_FIELD_SIZE = 10;

	private static final int H_VS_PC = 0;
	private static final int H_VS_H = 1;

	public Settings() {
		setBackground(Color.orange);
		setLayout(new GridLayout(10, 1));

		add(new JLabel("  Режим игры:"));
		HvsPC = new JRadioButton("Игра против ПК", true);
		HvsPC.setBackground(Color.orange);
		HvsH = new JRadioButton("Игра вдвоём");
		HvsH.setBackground(Color.orange);
		gameMode = new ButtonGroup();
		gameMode.add(HvsH);
		gameMode.add(HvsPC);
		add(HvsPC);
		add(HvsH);


		add(new JLabel("  Количество ячеек по горизонтали:"));
		jSliderFieldX = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
		jSliderFieldX.setBackground(Color.orange);
		jSliderFieldX.setMajorTickSpacing(1);
		jSliderFieldX.setPaintLabels(true);
		jSliderFieldX.setPaintTicks(true);
		add(jSliderFieldX);

		add(new JLabel("  КОличество ячеек по вертикали:"));
		jSliderFieldY = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
		jSliderFieldY.setBackground(Color.orange);
		jSliderFieldY.setMajorTickSpacing(1);
		jSliderFieldY.setPaintLabels(true);
		jSliderFieldY.setPaintTicks(true);
		add(jSliderFieldY);


		jSliderFieldX.addChangeListener(e -> {
			if (jSliderFieldX.getValue() > jSliderFieldY.getValue()) {
				jSliderWin.setMaximum(jSliderFieldX.getValue());
			} else {
				jSliderWin.setMaximum(jSliderFieldY.getValue());
			}
		});

		jSliderFieldY.addChangeListener(e -> {
			if (jSliderFieldY.getValue() > jSliderFieldX.getValue()) {
				jSliderWin.setMaximum(jSliderFieldY.getValue());
			} else {
				jSliderWin.setMaximum(jSliderFieldX.getValue());
			}
		});


		add(new JLabel("  Количество точек для победы:"));
		jSliderWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
		jSliderWin.setBackground(Color.orange);
		jSliderWin.setMajorTickSpacing(1);
		jSliderWin.setPaintLabels(true);
		jSliderWin.setPaintTicks(true);
		add(jSliderWin);

		setVisible(false);
	}

	public int gameModeValue(){
		if (HvsPC.isSelected()){
			return H_VS_PC;
		} else {
			return H_VS_H;
		}
	}

	public int fieldSizeX() {
		return jSliderFieldX.getValue();
	}

	public int fieldSizeY() {
		return jSliderFieldY.getValue();
	}

	public int winLength() {
		return jSliderWin.getValue();
	}
}
