import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentGUI extends Application 
{
    ObservableList<String> students = FXCollections.observableArrayList();
    ListView<String> listView = new ListView<>(students);

    private final Font customFont = Font.font("Bookman Old Style", javafx.scene.text.FontWeight.BOLD, 16);

    @Override
    public void start(Stage stage) 
    {
        // 🌟 Header
        Label title = new Label("🎓 Student Information System");
        title.setFont(Font.font("Bookman Old Style", javafx.scene.text.FontWeight.BOLD, 24));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label("Built using JavaFX GUI");
        subtitle.setFont(customFont);
        subtitle.setTextFill(Color.LIGHTYELLOW);

        VBox headerBox = new VBox(5, title, subtitle);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(15));
        headerBox.setStyle("-fx-background-color: linear-gradient(to right, #FF6F61, #FFB74D);");

        // 📄 Form Section
        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");
        nameField.setFont(customFont);

        TextField rollField = new TextField();
        rollField.setPromptText("Enter roll number");
        rollField.setFont(customFont);

        TextField emailField = new TextField();
        emailField.setPromptText("Enter email");
        emailField.setFont(customFont);

        Label nameLabel = new Label("Name");
        Label rollLabel = new Label("Roll No");
        Label emailLabel = new Label("Email");

        nameLabel.setFont(customFont);
        rollLabel.setFont(customFont);
        emailLabel.setFont(customFont);

        Button addBtn = new Button("Add");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

        addBtn.setFont(customFont);
        updateBtn.setFont(customFont);
        deleteBtn.setFont(customFont);

        addBtn.setStyle("-fx-background-color: #00C853; -fx-text-fill: white;");
        updateBtn.setStyle("-fx-background-color: #FFEB3B; -fx-text-fill: black;");
        deleteBtn.setStyle("-fx-background-color: #E53935; -fx-text-fill: white;");

        HBox buttonBox = new HBox(20, addBtn, updateBtn, deleteBtn);
        buttonBox.setAlignment(Pos.CENTER);

        VBox formBox = new VBox(12,
                nameLabel, nameField,
                rollLabel, rollField,
                emailLabel, emailField,
                buttonBox);
        formBox.setPadding(new Insets(20));
        formBox.setStyle("-fx-background-color: #e05ed7ff; -fx-border-color: #FF7043; -fx-border-radius: 10; -fx-background-radius: 10;");

        // 📋 List Section
        Label listLabel = new Label("List of Students:");
        listLabel.setFont(customFont);
        listLabel.setTextFill(Color.WHITE);

        listView.setStyle("-fx-font-family: 'Bookman Old Style'; -fx-font-size: 16px; -fx-font-weight: bold;");

        VBox listBox = new VBox(10, listLabel, listView);
        listBox.setPadding(new Insets(20));
        listBox.setStyle("-fx-background-color: linear-gradient(to right, #7C4DFF, #0ddd59ff); -fx-border-radius: 10; -fx-background-radius: 10;");

        // 📦 Main Layout
        VBox root = new VBox(25, headerBox, formBox, listBox);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #ffffffff, #E3F2FD);");

        // 🧠 Events
        addBtn.setOnAction(e -> 
        {
            String name = nameField.getText();
            String roll = rollField.getText();
            String email = emailField.getText();
            if (!name.isEmpty() && !roll.isEmpty() && !email.isEmpty()) 
            {
                students.add(name + " | " + roll + " | " + email);
                nameField.clear(); rollField.clear(); emailField.clear();
            }
        });

        updateBtn.setOnAction(e -> 
        {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                String name = nameField.getText();
                String roll = rollField.getText();
                String email = emailField.getText();
                students.set(index, name + " | " + roll + " | " + email);
                nameField.clear(); rollField.clear(); emailField.clear();
            }
        });

        deleteBtn.setOnAction(e -> 
        {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) 
            {
                students.remove(index);
                nameField.clear(); rollField.clear(); emailField.clear();
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> 
        {
            if (newVal != null) 
            {
                String[] parts = newVal.split(" \\| ");
                if (parts.length == 3) {
                    nameField.setText(parts[0]);
                    rollField.setText(parts[1]);
                    emailField.setText(parts[2]);
                }
            }
        });

        // 🎬 Final Scene
        Scene scene = new Scene(root, 600, 720);
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch();
    }
}
