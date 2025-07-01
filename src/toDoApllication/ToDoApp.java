package toDoApllication;

import javax.swing.*;


import java.awt.event.*;

public class ToDoApp {
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

        
        JTextField taskField = new JTextField(20); 
        JButton addButton = new JButton("Add Task"); 
        JButton deleteButton = new JButton("Delete Task"); 

      
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList); // scroll bar

       
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

       
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim(); 
                if (!task.isEmpty()) {
                    taskListModel.addElement(task); 
                    taskField.setText("");
                }
            }
        });

        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete.");
                }
            }
        });

        
        frame.add(inputPanel, "North");   
        frame.add(scrollPane, "Center"); 
        frame.add(buttonPanel, "South");  
        
       
        frame.setVisible(true);
    }
}