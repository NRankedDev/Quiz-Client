package de.quiz.state;

import de.quiz.net.QuestionPacket;
import de.salocin.gameenginefx.gui.Component;
import de.salocin.gameenginefx.gui.layout.RelativeData;
import de.salocin.gameenginefx.gui.text.TextAlgin;
import de.salocin.gameenginefx.render.MenuRenderState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InGame extends MenuRenderState {
	
	public static final InGame INSTANCE = new InGame();
	
	private static final Font LABEL_FONT = new Font("Segoe Print", 0);
	private static final Color LABEL_TITLE = Color.WHITE;
	private static final Color LABEL_BACKGROUND = Color.rgb(51, 204, 255);
	private static final double LABEL_WIDTH_PERCENTAGE = 25;
	private static final double LABEL_HEIGHT_PERCENTAGE = 17;
	private static final double LABEL_PADDING = 10.0;
	
	private final Component QUESTION_LABEL = new Component();
	private final Component ANSWER_1_LABEL = new Component();
	private final Component ANSWER_2_LABEL = new Component();
	private final Component ANSWER_3_LABEL = new Component();
	private final Component ANSWER_4_LABEL = new Component();
	
	private QuestionPacket question;
	
	@Override
	public void init(Canvas canvas) {
		QUESTION_LABEL.setTitleColor(LABEL_TITLE);
		QUESTION_LABEL.setTitleFont(LABEL_FONT);
		QUESTION_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		QUESTION_LABEL.setTitleHorizontalAlgin(TextAlgin.ABSOLUTE);
		QUESTION_LABEL.setTitleVerticalAlgin(TextAlgin.ABSOLUTE);
		QUESTION_LABEL.setLayoutData(new RelativeData().top(LABEL_HEIGHT_PERCENTAGE, 0).left(50 - LABEL_WIDTH_PERCENTAGE, 0).width(LABEL_WIDTH_PERCENTAGE * 2, LABEL_PADDING).height(LABEL_HEIGHT_PERCENTAGE * 1.7, 0));
		
		ANSWER_1_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_1_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_1_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_1_LABEL.setTitleHorizontalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_1_LABEL.setTitleVerticalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_1_LABEL.setLayoutData(new RelativeData().top(QUESTION_LABEL).left(50 - LABEL_WIDTH_PERCENTAGE, 0).width(LABEL_WIDTH_PERCENTAGE, 0).height(LABEL_HEIGHT_PERCENTAGE, 0));
		
		ANSWER_2_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_2_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_2_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_2_LABEL.setTitleHorizontalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_2_LABEL.setTitleVerticalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_2_LABEL.setLayoutData(new RelativeData().top(QUESTION_LABEL).left(ANSWER_1_LABEL, LABEL_PADDING).width(LABEL_WIDTH_PERCENTAGE, 0).height(LABEL_HEIGHT_PERCENTAGE, 0));
		
		ANSWER_3_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_3_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_3_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_3_LABEL.setTitleHorizontalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_3_LABEL.setTitleVerticalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_3_LABEL.setLayoutData(new RelativeData().top(ANSWER_1_LABEL).left(50 - LABEL_WIDTH_PERCENTAGE, 0).width(LABEL_WIDTH_PERCENTAGE, 0).height(LABEL_HEIGHT_PERCENTAGE, 0));
		
		ANSWER_4_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_4_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_4_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_4_LABEL.setTitleHorizontalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_4_LABEL.setTitleVerticalAlgin(TextAlgin.ABSOLUTE);
		ANSWER_4_LABEL.setLayoutData(new RelativeData().top(ANSWER_2_LABEL).left(ANSWER_3_LABEL, LABEL_PADDING).width(LABEL_WIDTH_PERCENTAGE, 0).height(LABEL_HEIGHT_PERCENTAGE, 0));
		
		addComponent(QUESTION_LABEL);
		addComponent(ANSWER_1_LABEL);
		addComponent(ANSWER_2_LABEL);
		addComponent(ANSWER_3_LABEL);
		addComponent(ANSWER_4_LABEL);
		
		question = new QuestionPacket("Beantworte diese Frage\nSecond line", "Richtig oder falsch das ist hier die Frage. Ja, da stimme ich dir vollkommen zu!", "Falsch", "Falsch", "Falsch");
		
		QUESTION_LABEL.setTitle(question.getQuestion());
		ANSWER_1_LABEL.setTitle(question.getAnswers()[0]);
		ANSWER_2_LABEL.setTitle(question.getAnswers()[1]);
		ANSWER_3_LABEL.setTitle(question.getAnswers()[2]);
		ANSWER_4_LABEL.setTitle(question.getAnswers()[3]);
	}
	
	@Override
	public void update(Canvas canvas, long delta, long fps) {
		super.update(canvas, delta, fps);
		
		// QUESTION_LABEL.setTitle(question.getQuestion());
		// ANSWER_1_LABEL.setTitle(question.getAnswers()[0]);
		// ANSWER_2_LABEL.setTitle(question.getAnswers()[1]);
		// ANSWER_3_LABEL.setTitle(question.getAnswers()[2]);
		// ANSWER_4_LABEL.setTitle(question.getAnswers()[3]);
	}
	
	@Override
	public void render(Canvas canvas, GraphicsContext gc) {
		super.render(canvas, gc);
	}
	
}
