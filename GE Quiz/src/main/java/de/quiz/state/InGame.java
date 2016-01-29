package de.quiz.state;

import de.quiz.net.QuestionPacket;
import de.salocin.gameenginefx.gui.Component;
import de.salocin.gameenginefx.gui.layout.RelativeData;
import de.salocin.gameenginefx.render.MenuRenderState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InGame extends MenuRenderState {
	
	public static final InGame INSTANCE = new InGame();
	
	private static final Font LABEL_FONT = new Font("Arial Bold", 20);
	private static final Color LABEL_TITLE = Color.WHITE;
	private static final Color LABEL_BACKGROUND = Color.rgb(51, 204, 255);
	private static final double LABEL_WIDTH = 250.0;
	private static final double LABEL_HEIGHT = 100.0;
	private static final double LABEL_PADDING = 10.0;
	
	private final Component QUESTION_LABEL = new Component();
	private final Component ANSWER_1_LABEL = new Component();
	private final Component ANSWER_2_LABEL = new Component();
	private final Component ANSWER_3_LABEL = new Component();
	private final Component ANSWER_4_LABEL = new Component();
	
	private QuestionPacket question;
	
	@Override
	public void init(Canvas canvas) {
		double startXOffset = -LABEL_WIDTH - LABEL_PADDING / 2;
		double startYOffset = -(LABEL_HEIGHT * 2) - LABEL_PADDING;
		
		QUESTION_LABEL.setTitleColor(LABEL_TITLE);
		QUESTION_LABEL.setTitleFont(LABEL_FONT);
		QUESTION_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		QUESTION_LABEL.setLayoutData(new RelativeData().top(50, startYOffset).left(50, startXOffset).width(LABEL_WIDTH * 2 + LABEL_PADDING).height(LABEL_HEIGHT * 2));
		
		ANSWER_1_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_1_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_1_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_1_LABEL.setLayoutData(new RelativeData().top(QUESTION_LABEL).left(50, startXOffset).width(LABEL_WIDTH).height(LABEL_HEIGHT));
		
		ANSWER_2_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_2_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_2_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_2_LABEL.setLayoutData(new RelativeData().top(QUESTION_LABEL).left(ANSWER_1_LABEL, LABEL_PADDING).width(LABEL_WIDTH).height(LABEL_HEIGHT));
		
		ANSWER_3_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_3_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_3_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_3_LABEL.setLayoutData(new RelativeData().top(ANSWER_1_LABEL).left(50, startXOffset).width(LABEL_WIDTH).height(LABEL_HEIGHT));
		
		ANSWER_4_LABEL.setTitleColor(LABEL_TITLE);
		ANSWER_4_LABEL.setTitleFont(LABEL_FONT);
		ANSWER_4_LABEL.setBackgroundColor(LABEL_BACKGROUND);
		ANSWER_4_LABEL.setLayoutData(new RelativeData().top(ANSWER_2_LABEL).left(ANSWER_3_LABEL, LABEL_PADDING).width(LABEL_WIDTH).height(LABEL_HEIGHT));
		
		addComponent(QUESTION_LABEL);
		addComponent(ANSWER_1_LABEL);
		addComponent(ANSWER_2_LABEL);
		addComponent(ANSWER_3_LABEL);
		addComponent(ANSWER_4_LABEL);
		
		question = new QuestionPacket("Beantworte diese Frage", "Richtig", "Falsch", "Falsch", "Falsch");
	}
	
	@Override
	public void update(Canvas canvas, long delta, long fps) {
		super.update(canvas, delta, fps);
		
		QUESTION_LABEL.setTitle(question.getQuestion());
		ANSWER_1_LABEL.setTitle(question.getAnswers()[0]);
		ANSWER_2_LABEL.setTitle(question.getAnswers()[1]);
		ANSWER_3_LABEL.setTitle(question.getAnswers()[2]);
		ANSWER_4_LABEL.setTitle(question.getAnswers()[3]);
	}
	
	@Override
	public void render(Canvas canvas, GraphicsContext gc) {
		super.render(canvas, gc);
	}
	
}
