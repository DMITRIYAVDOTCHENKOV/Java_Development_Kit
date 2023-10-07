package lekciya1.game;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


//Задача: На лекции был написан фрейм, содержащий одну кнопку – начать игру и расположением самого окна настроек
//автоматически, относительно игрового окна.
//Добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты
//в заданном порядке: JLabel с заголовком «Выберите режим игры»,
//сгруппированные в ButtonGroup переключаемые JRadioButton с указанием режимов «Человек против компьютера» и
//«Человек против человека», JLabel с заголовком «Выберите размеры поля»,
//JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10, JLabel с заголовком
//«Выберите длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.
public class SettingWindow extends JFrame {
    public static final String BTN_START = "Start new game";
    public static final String LABEL_CHOICE_MODE = "Выберите режим игры";
    public static final String BTN_HUMAN_VERSUS_AI = "Человек VS Робот";
    public static final String BTN_HUMAN_VERSUS_HUMAN = "Человек VS Человек";
    public static final String SIZE_PREFIX = "Установленная длина: ";
    public static final String LABEL_CHOICE_SIZE = "Установленная длина: ";
    public static final String LABEL_CHOICE_WIN_LENGTH = "Выберите длину для победы: ";
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 10;

    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    private static final String WIN_LENGTH_PREFIX = "Выберите длину для победы";
    GameWindow gameWindow;
    JButton btnStart;
    JRadioButton humanVHuman, humanVAI;
    Label labelCurSize, labelWinLength;
    JSlider sizeSlider, winSlider;


    JRadioButton human;
    JSlider sliderFieldSize;
    JLabel currentFieldSize;
    JLabel currentWinSize;
    ButtonGroup buttonGroup;
    JLabel choiceHI;
    JPanel panelMain;
    JLabel fieldSize;
    JLabel winSize;

    SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        int centerGameWindowX = gameWindow.getX() + gameWindow.getWidth() / 2;
        int centerGameWindowY = gameWindow.getY() + gameWindow.getWidth() / 2;
        setLocation(centerGameWindowX - WIDTH / 2, centerGameWindowY - HEIGHT / 2);
        setSize(WIDTH, HEIGHT);

        add(createMainPanel());
        add(createButtonStart(), BorderLayout.SOUTH);
    }

    private Component createMainPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        panel.add(createChoiceModePAnel());
        panel.add(createChoiceSizePanel());
        panel.add(createChoiceWinLengthPanel());
        return panel;
    }

    private Component createChoiceWinLengthPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_CHOICE_WIN_LENGTH);
        labelWinLength = new Label(WIN_LENGTH_PREFIX + MIN_SIZE);
        winSlider = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        winSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(SIZE_PREFIX + winSlider.getValue());
            }
        });

        panel.add(title);
        panel.add(labelWinLength);
        panel.add(winSlider);
        return panel;
    }



    private Component createChoiceSizePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_CHOICE_SIZE);
        labelCurSize = new Label(SIZE_PREFIX + MIN_SIZE);
        sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        sizeSlider.addChangeListener(e -> {
            int curSize = sizeSlider.getValue();
            labelCurSize.setText(SIZE_PREFIX + curSize);
            winSlider.setMaximum(curSize);
        });

        panel.add(title);
        panel.add(labelCurSize);
        panel.add(sizeSlider);

        return panel;
    }

    private Component createChoiceModePAnel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_CHOICE_MODE);
        ButtonGroup buttonGroup = new ButtonGroup();
        humanVAI = new JRadioButton(BTN_HUMAN_VERSUS_AI);
        humanVHuman = new JRadioButton(BTN_HUMAN_VERSUS_HUMAN);
        buttonGroup.add(humanVAI);
        buttonGroup.add(humanVHuman);
        humanVAI.setSelected(true);

        panel.add(title);
        panel.add(humanVAI);
        panel.add(humanVHuman);

        return panel;
    }

    private Component createButtonStart() {
        btnStart = new JButton(BTN_START);
        btnStart.addActionListener(e -> {
            setVisible(false);
            startGame();
        });
        return btnStart;
    }

    private void startGame() {
        int mode;
        if (humanVAI.isSelected()){
            mode = MODE_HVA;
        } else if (humanVHuman.isSelected()){
            mode = MODE_HVH;
        } else {
            throw new RuntimeException("Unknown game mode");
        }
        int size = sizeSlider.getValue();
        int winLength = winSlider.getValue();
        gameWindow.startNewGame(mode, size, size, winLength);
    }

//        human = new JRadioButton(BTN_HUMAN_VERSUS_HUMAN);
//        aI = new JRadioButton(BTN_HUMAN_VERSUS_AI);
//        buttonGroup = new ButtonGroup();
//        buttonGroup.add(aI);
//        buttonGroup.add(human);
//        btnStart = new JButton(BTN_START);
//        panelMain = new JPanel(new GridLayout(9, 1));
//        fieldSize = new JLabel("Выберите размер поля!");
//        choiceHI = new JLabel(LABEL_CHOICE_MODE);
//        currentFieldSize = new JLabel(SIZE_PREFIX);
//        sliderFieldSize = new JSlider(MIN_SIZE, MAX_SIZE, 3);
//        winSize = new JLabel(LABEL_CHOICE_WIN_LENGTH);
//        currentWinSize = new JLabel(LABEL_CHOICE_SIZE);
//        sliderWinSize = new JSlider(MIN_SIZE, MAX_SIZE, 3);
//        panelMain.add(choiceHI);
//
//        setLocationRelativeTo(gameWindow);
//        setSize(WIDTH, HEIGHT);
//
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                gameWindow.startNewGame(0, 3, 3, 3);
//            }
//        });
//        panelMain.add(human);
//        panelMain.add(aI);
//        panelMain.add(fieldSize);
//        panelMain.add(currentFieldSize);
//        panelMain.add(sliderFieldSize);
//        panelMain.add(winSize);
//        panelMain.add(currentWinSize);
//        panelMain.add(sliderWinSize);
//        add(panelMain);
//        add(btnStart, BorderLayout.SOUTH);
//    }
}
