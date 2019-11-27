/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivadam.subnetcalculator;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.SimpleTableModel;
import org.netbeans.microedition.lcdui.TableItem;

/**
 * @author damir
 */
public class ConvertedMain extends MIDlet implements CommandListener {

// HINT - Uncomment for accessing new MIDlet Started/Resumed logic.
    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form mainForm;
    private TextField textIP;
    private StringItem stringClass;
    private ChoiceGroup choiceSubnetCount;
    private StringItem stringBits;
    private StringItem stringMask;
    private Form tableForm;
    private TableItem tableItem2;
    private Command exitCommand;
    private Command calcCommand;
    private Command tableCommand;
    private Command backCommand1;
    private SimpleTableModel simpleTableModel;
    //</editor-fold>//GEN-END:|fields|0|


// HINT - Uncomment for accessing new MIDlet Started/Resumed logic.
// NOTE - Be aware of resolving conflicts of the constructor.
    /**
     * The ConvertedMain constructor.
     */
    public ConvertedMain() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getMainForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
    // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
    // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // Insert global pre-action code here
        if (displayable == mainForm) {//GEN-BEGIN:|7-commandAction|1|18-preAction
            if (command == calcCommand) {//GEN-END:|7-commandAction|1|18-preAction
                // Insert pre-action code here
//GEN-LINE:|7-commandAction|2|18-postAction
                // Insert post-action code here
                //simpleTableModel1.
                //this.choiceSubnets.deleteAll();
                String[] ipStr = Utils.split(textIP.getString(), ".");
                this.stringClass.setText(Utils.getAddressClass(textIP.getString()));
                this.stringBits.setText(String.valueOf(this.choiceSubnetCount.getSelectedIndex()));
                this.stringMask.setText(Utils.getMask(this.choiceSubnetCount.getSelectedIndex() + Utils.getDefaultMaskPreffix(this.stringClass.getText())));
                long maxHostsPerSub = Utils.pow(2, 32 - this.choiceSubnetCount.getSelectedIndex() - Utils.getDefaultMaskPreffix(this.stringClass.getText()));
                //System.out.println(String.valueOf(maxHostsPerSub));
                Integer[] ipInt = new Integer[4];
                for (int i = 0; i < 4; i++) {
                    ipInt[i] = Integer.valueOf(ipStr[i]);
                }

                long ipDec = ipInt[0].longValue() * Utils.pow(256, 3) + ipInt[1].longValue() * Utils.pow(256, 2) + ipInt[2].longValue() * Utils.pow(256, 1) + ipInt[3].longValue() * Utils.pow(256, 0);

                long maxHosts = 0;
                if (stringClass.getText().equals("A")) {
                    maxHosts = Utils.pow(256, 3);
                } else if (stringClass.getText().equals("B")) {
                    maxHosts = Utils.pow(256, 2);
                } else if (stringClass.getText().equals("C")) {
                    maxHosts = Utils.pow(256, 1);
                }

                int subnetCount = Integer.parseInt(this.choiceSubnetCount.getString(this.choiceSubnetCount.getSelectedIndex()));

                String[][] tableValues = new String[subnetCount][5];


                //this.stringOsztaly.setText(String.valueOf(ipDec));
                for (int i = 0; i < subnetCount; i++) {
                    long ipDec1 = ipDec + i * (maxHosts / subnetCount);
                    String ipv4 = String.valueOf(ipDec1 / 16777216l % 256l) + "." + String.valueOf(ipDec1 / 65536l % 256l) + "." + String.valueOf(ipDec1 / 256l % 256l) + "." + String.valueOf(ipDec1 / 1l % 256l);
                    tableValues[i][0] = ipv4;

                    // host start
                    ipDec1 = ipDec + i * (maxHosts / subnetCount) + 1;
                    ipv4 = String.valueOf(ipDec1 / 16777216l % 256l) + "." + String.valueOf(ipDec1 / 65536l % 256l) + "." + String.valueOf(ipDec1 / 256l % 256l) + "." + String.valueOf(ipDec1 / 1l % 256l);
                    tableValues[i][1] = ipv4;

                    // host end
                    ipDec1 = ipDec + i * (maxHosts / subnetCount) + maxHostsPerSub - 2;
                    ipv4 = String.valueOf(ipDec1 / 16777216l % 256l) + "." + String.valueOf(ipDec1 / 65536l % 256l) + "." + String.valueOf(ipDec1 / 256l % 256l) + "." + String.valueOf(ipDec1 / 1l % 256l);
                    tableValues[i][2] = ipv4;

                    // broadcast
                    ipDec1 = ipDec + i * (maxHosts / subnetCount) + maxHostsPerSub - 1;
                    ipv4 = String.valueOf(ipDec1 / 16777216l % 256l) + "." + String.valueOf(ipDec1 / 65536l % 256l) + "." + String.valueOf(ipDec1 / 256l % 256l) + "." + String.valueOf(ipDec1 / 1l % 256l);
                    tableValues[i][3] = ipv4;
                }
                getSimpleTableModel().setValues(tableValues);
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|15-preAction
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|15-postAction
            // Insert post-action code here
            } else if (command == tableCommand) {//GEN-LINE:|7-commandAction|5|20-preAction
                // Insert pre-action code here
                switchDisplayable(null, getTableForm());//GEN-LINE:|7-commandAction|6|20-postAction
            // Insert post-action code here
            }//GEN-BEGIN:|7-commandAction|7|23-preAction
        } else if (displayable == tableForm) {
            if (command == backCommand1) {//GEN-END:|7-commandAction|7|23-preAction
                // Insert pre-action code here
                switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|8|23-postAction
            // Insert post-action code here
            }//GEN-BEGIN:|7-commandAction|9|7-postCommandAction
        }//GEN-END:|7-commandAction|9|7-postCommandAction
    // Insert global post-action code here
    }//GEN-BEGIN:|7-commandAction|10|
    //</editor-fold>//GEN-END:|7-commandAction|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: mainForm ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of mainForm component.
     * @return the initialized component instance
     */
    public Form getMainForm() {
        if (mainForm == null) {//GEN-END:|14-getter|0|14-preInit
            // Insert pre-init code here
            mainForm = new Form("Damir\'s SubnetCalculator 1.0", new Item[] { getTextIP(), getChoiceSubnetCount(), getStringClass(), getStringBits(), getStringMask() });//GEN-BEGIN:|14-getter|1|14-postInit
            mainForm.addCommand(getExitCommand());
            mainForm.addCommand(getCalcCommand());
            mainForm.addCommand(getTableCommand());
            mainForm.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|14-getter|2|
        return mainForm;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textIP ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of textIP component.
     * @return the initialized component instance
     */
    public TextField getTextIP() {
        if (textIP == null) {//GEN-END:|29-getter|0|29-preInit
            // Insert pre-init code here
            textIP = new TextField("IP address:", "129.250.0.0", 32, TextField.ANY);//GEN-BEGIN:|29-getter|1|29-postInit
            textIP.setInitialInputMode("UCB_BASIC_LATIN");//GEN-END:|29-getter|1|29-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|29-getter|2|
        return textIP;
    }
    //</editor-fold>//GEN-END:|29-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceSubnetCount ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of choiceSubnetCount component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceSubnetCount() {
        if (choiceSubnetCount == null) {//GEN-END:|30-getter|0|30-preInit
            // Insert pre-init code here
            choiceSubnetCount = new ChoiceGroup("Subnet count:", Choice.POPUP);//GEN-BEGIN:|30-getter|1|30-postInit
            choiceSubnetCount.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|30-getter|1|30-postInit
            // Insert post-init code here
            for (int i = 0; i < 24; i++) {
                choiceSubnetCount.append(String.valueOf(Utils.pow(2, i)), null);
            }
        }//GEN-BEGIN:|30-getter|2|
        return choiceSubnetCount;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringClass ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of stringClass component.
     * @return the initialized component instance
     */
    public StringItem getStringClass() {
        if (stringClass == null) {//GEN-END:|31-getter|0|31-preInit
            // Insert pre-init code here
            stringClass = new StringItem("Network class:", "", Item.PLAIN);//GEN-BEGIN:|31-getter|1|31-postInit
            stringClass.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|31-getter|1|31-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|31-getter|2|
        return stringClass;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringBits ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of stringBits component.
     * @return the initialized component instance
     */
    public StringItem getStringBits() {
        if (stringBits == null) {//GEN-END:|32-getter|0|32-preInit
            // Insert pre-init code here
            stringBits = new StringItem("Required bits:", "");//GEN-LINE:|32-getter|1|32-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|32-getter|2|
        return stringBits;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringMask ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of stringMask component.
     * @return the initialized component instance
     */
    public StringItem getStringMask() {
        if (stringMask == null) {//GEN-END:|33-getter|0|33-preInit
            // Insert pre-init code here
            stringMask = new StringItem("Network mask:", "");//GEN-LINE:|33-getter|1|33-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|33-getter|2|
        return stringMask;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableForm ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of tableForm component.
     * @return the initialized component instance
     */
    public Form getTableForm() {
        if (tableForm == null) {//GEN-END:|22-getter|0|22-preInit
            // Insert pre-init code here
            tableForm = new Form("Damir\'s SubnetCalculator 1.0", new Item[] { getTableItem2() });//GEN-BEGIN:|22-getter|1|22-postInit
            tableForm.addCommand(getBackCommand1());
            tableForm.setCommandListener(this);//GEN-END:|22-getter|1|22-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|22-getter|2|
        return tableForm;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem2 ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of tableItem2 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem2() {
        if (tableItem2 == null) {//GEN-END:|26-getter|0|26-preInit
            // Insert pre-init code here
            tableItem2 = new TableItem(getDisplay(), "");//GEN-BEGIN:|26-getter|1|26-postInit
            tableItem2.setTitle("Subnets");
            tableItem2.setModel(getSimpleTableModel());//GEN-END:|26-getter|1|26-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|26-getter|2|
        return tableItem2;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|16-getter|0|16-preInit
            // Insert pre-init code here
            exitCommand = new Command("Exit", Command.EXIT, 1);//GEN-LINE:|16-getter|1|16-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|16-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|16-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: calcCommand ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initiliazed instance of calcCommand component.
     * @return the initialized component instance
     */
    public Command getCalcCommand() {
        if (calcCommand == null) {//GEN-END:|19-getter|0|19-preInit
            // Insert pre-init code here
            calcCommand = new Command("Calc", Command.ITEM, 1);//GEN-LINE:|19-getter|1|19-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|19-getter|2|
        return calcCommand;
    }
    //</editor-fold>//GEN-END:|19-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableCommand ">//GEN-BEGIN:|21-getter|0|21-preInit
    /**
     * Returns an initiliazed instance of tableCommand component.
     * @return the initialized component instance
     */
    public Command getTableCommand() {
        if (tableCommand == null) {//GEN-END:|21-getter|0|21-preInit
            // Insert pre-init code here
            tableCommand = new Command("Show subnets", Command.SCREEN, 2);//GEN-LINE:|21-getter|1|21-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|21-getter|2|
        return tableCommand;
    }
    //</editor-fold>//GEN-END:|21-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|24-getter|0|24-preInit
            // Insert pre-init code here
            backCommand1 = new Command("Back", Command.BACK, 1);//GEN-LINE:|24-getter|1|24-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|24-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: simpleTableModel ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initiliazed instance of simpleTableModel component.
     * @return the initialized component instance
     */
    public SimpleTableModel getSimpleTableModel() {
        if (simpleTableModel == null) {//GEN-END:|27-getter|0|27-preInit
            // Insert pre-init code here
            simpleTableModel = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|27-getter|1|27-postInit
                new java.lang.String[] { "", "", "", "", "" }}, new java.lang.String[] { "Subnet", "Host1", "Host2", "Broadcast", "Usable" });//GEN-END:|27-getter|1|27-postInit
        // Insert post-init code here
        }//GEN-BEGIN:|27-getter|2|
        return simpleTableModel;
    }
    //</editor-fold>//GEN-END:|27-getter|2|



    /**
     * This method should return an instance of the display.
     */
    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {

        return Display.getDisplay(this);
    // return Display.getDisplay (this);
    }

    /**
     * This method should exit the midlet.
     */
    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {

        getDisplay().setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    // switchDisplayable (null, null);
    // destroyApp(true);
    // notifyDestroyed();
    }

//    /** Creates a new instance of MainForm */
//    public ConvertedMain() {
//        initialize();
//        for (int i = 0; i < 24; i++) {
//            choiceSubnetCount.append(String.valueOf(Utils.pow(2, i)), null);
//        }
//    }
//    public void startApp() {
//    }
//
//    public void pauseApp() {
//    }
//
//    public void destroyApp(boolean unconditional) {
//    }
// HINT - Uncomment for accessing new MIDlet Started/Resumed logic.
// NOTE - Be aware of resolving conflicts of following methods.
    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
