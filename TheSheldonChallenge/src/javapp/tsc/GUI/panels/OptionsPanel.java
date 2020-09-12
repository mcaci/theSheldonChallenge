package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.listeners.options.LanguageChoiceActionListener;
import javapp.tsc.GUI.listeners.options.RuleChoiceActionListener;
import javapp.tsc.GUI.listeners.options.SaveOptionsActionListener;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.base.TitledPanel;
import javapp.tsc.GUI.panels.components.buttons.fullSized.BackButton;
import javapp.tsc.GUI.panels.components.buttons.halfSized.SaveButton;
import javapp.tsc.core.GUICore;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.BackButtonLabel;
import javapp.tsc.lang.vocab.OptionMenuLabel;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.rule.Rule;

public final class OptionsPanel extends TitledPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4269481537034016373L;

	private JComboBox langComboBox;
	private JComboBox rulesComboBox;
	private JTextField scoreTextArea;

	public OptionsPanel(TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.OPTIONS);
		final Language currentLang = AppCore.getInstance().getSessionLanguage();
		try {
			FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0,
					1);
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				{
					JLabel langLabel = new JLabel();
					this.getMiddlePanel().add(langLabel);
					langLabel.setText(new XMLFileTranslator().translate(
							OptionMenuLabel.LANGUAGE, currentLang));
					langLabel.setHorizontalAlignment(JLabel.CENTER);
					langLabel.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 20));
				}
				{
					ComboBoxModel langComboBoxModel = new DefaultComboBoxModel(
							Language.getStringVector());
					langComboBox = new JComboBox();
					this.getMiddlePanel().add(langComboBox);
					langComboBox.setModel(langComboBoxModel);
					langComboBox.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 20));
					langComboBox.setSelectedIndex(AppCore.getInstance()
							.getSessionLanguage().ordinal());
					langComboBox
							.addActionListener(new LanguageChoiceActionListener(
									this));
				}
				{
					JLabel ruleLabel = new JLabel();
					this.getMiddlePanel().add(ruleLabel);
					ruleLabel.setHorizontalAlignment(JLabel.CENTER);
					ruleLabel.setText(new XMLFileTranslator().translate(
							OptionMenuLabel.RULE, currentLang));
					ruleLabel.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 20));
				}
				{
					ComboBoxModel ruleComboBoxModel = new DefaultComboBoxModel(
							Rule.getStringVector());
					rulesComboBox = new JComboBox();
					this.getMiddlePanel().add(rulesComboBox);
					rulesComboBox.setModel(ruleComboBoxModel);
					rulesComboBox.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 20));
					rulesComboBox.setSelectedIndex(AppCore.getInstance()
							.getSessionRule().ordinal());
					rulesComboBox
							.addActionListener(new RuleChoiceActionListener(
									this));
				}
				{
					JLabel scoreToWinLabel = new JLabel();
					this.getMiddlePanel().add(scoreToWinLabel);
					scoreToWinLabel.setHorizontalAlignment(JLabel.CENTER);
					scoreToWinLabel.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 20));
					scoreToWinLabel.setText(new XMLFileTranslator().translate(
							OptionMenuLabel.SCORE_TO_WIN, currentLang));
				}
				{
					scoreTextArea = new JTextField();
					this.getMiddlePanel().add(scoreTextArea);
					scoreTextArea.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 20));
					scoreTextArea.setText(Integer.toString(AppCore
							.getInstance().getScoreToWin()));
				}
				{
					FillerPanel filler = new FillerPanel(20);
					this.getMiddlePanel().add(filler);
				}
				{
					SaveButton saveButton = new SaveButton(this);
					this.getMiddlePanel().add(saveButton);
					// TODO: to remove
					saveButton.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 35));
					saveButton.addActionListener(new SaveOptionsActionListener(
							this));
				}
				{
					BackButton backButton = new BackButton(this,
							BackButtonLabel.CANCEL);
					this.getMiddlePanel().add(backButton);
					backButton.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 35));
					backButton
							.addActionListener(new PanelStateTransitionListener(
									this, PanelState.MAIN_MENU));
				}
			}
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	/**
	 * @return the langComboBox
	 */
	public final JComboBox getLangComboBox() {
		return langComboBox;
	}

	/**
	 * @return the rulesComboBox
	 */
	public final JComboBox getRulesComboBox() {
		return rulesComboBox;
	}

	/**
	 * @return the scoreTextArea
	 */
	public final JTextField getScoreTextArea() {
		return scoreTextArea;
	}

}
