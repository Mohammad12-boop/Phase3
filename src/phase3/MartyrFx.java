package phase3;


import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MartyrFx {

	private BorderPane pane;
	private Avl_tree<MartyrRecord> martyrs;
	String date;
	TextArea Result;
	private ComboBox<String> cbLocations;
	private ComboBox<DistrictRecord> cbDistricts;

	public MartyrFx() {

		Text text;
		Label lblInsert, lblUpdate, lblDelete, lblShow, lblPrint, lblPrintTable;
		TextField tfDelete, tfUpdate;
		Button btInsert, btDelete, btUpdate, btShow, btPrint, btPrintTable;
		Alert alertC, alertW;

		cbDistricts = new ComboBox<>();
		cbDistricts.setPromptText("Districts");

		cbLocations = new ComboBox<>();
		cbLocations.setPromptText("Locations");

		martyrs = new Avl_tree<>();

		alertC = new Alert(AlertType.CONFIRMATION);
		alertC.setTitle("Confirming");

		alertW = new Alert(AlertType.WARNING);
		alertW.setTitle("Warning");

//-------------------------------------------------------------------------------------------
		// This pane in the top of borderPane.

		StackPane pane1 = new StackPane();
		pane1.setPadding(new Insets(11, 12, 13, 14));
		text = new Text("Martyr Screen");
		text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 40));
		pane1.getChildren().add(text);

//-------------------------------------------------------------------------------------------
		// This pane in the left of borderPane.

		GridPane pane2 = new GridPane();
		pane2.setPadding(new Insets(11, 12, 13, 14));
		pane2.setHgap(10);
		pane2.setVgap(10);

		btInsert = new Button("Insert");
		btInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblInsert = new Label("Insert a new martyr:");
		lblInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane2.add(lblInsert, 0, 0);
		pane2.add(btInsert, 0, 1);

		tfDelete = new TextField();
		btDelete = new Button("Delete");
		btDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblDelete = new Label("Delete a martyr:");
		lblDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane2.add(lblDelete, 0, 2);
		pane2.add(tfDelete, 0, 3);
		pane2.add(btDelete, 1, 3);

		tfUpdate = new TextField();
		btUpdate = new Button("Update");
		btUpdate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblUpdate = new Label("Update a martyr:");
		lblUpdate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane2.add(lblUpdate, 0, 4);
		pane2.add(tfUpdate, 0, 5);
		pane2.add(btUpdate, 1, 5);

		GridPane pane3 = new GridPane();
		pane3.setPadding(new Insets(11, 12, 13, 14));
		pane3.setHgap(10);
		pane3.setVgap(10);

		btShow = new Button("Show");
		btShow.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblShow = new Label("Show the tree size & height:");
		lblShow.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane3.add(lblShow, 0, 0);
		pane3.add(btShow, 0, 1);

		btPrint = new Button("Print");
		btPrint.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblPrint = new Label("Print the tree:");
		lblPrint.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane3.add(lblPrint, 0, 2);
		pane3.add(btPrint, 0, 3);

		btPrintTable = new Button("Print Table");
		btPrintTable.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblPrintTable = new Label("Print the martyrs in table:");
		lblPrintTable.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane3.add(lblPrintTable, 0, 4);
		pane3.add(btPrintTable, 0, 5);

// -----------------------------------------------------------------------------------------
		// This for insert a new martyr (pane in the right of the borderPane).

		GridPane gpInsert = new GridPane();
		gpInsert.setPadding(new Insets(11, 12, 13, 14));
		gpInsert.setAlignment(Pos.CENTER);
		gpInsert.setHgap(10);
		gpInsert.setVgap(10);

		Label lblName = new Label("Name: ");
		lblName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfName = new TextField();
		gpInsert.add(lblName, 0, 0);
		gpInsert.add(tfName, 1, 0);

		Label lblAge = new Label("Age: ");
		lblAge.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfAge = new TextField();
		gpInsert.add(lblAge, 0, 1);
		gpInsert.add(tfAge, 1, 1);

		Label lblDistrict = new Label("District: ");
		lblDistrict.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpInsert.add(lblDistrict, 0, 2);
		StackPane sh2=new StackPane();
		ComboBox<DistrictRecord> dis=new ComboBox<>();
		dis.setPromptText("Districts");
		sh2.getChildren().add(dis);
		gpInsert.add(sh2, 1, 2);

		Label lblLocation = new Label("Location: ");
		lblLocation.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpInsert.add(lblLocation, 0, 3);
		StackPane sh2_1=new StackPane();
		ComboBox<String> loc=new ComboBox<>();
		loc.setPromptText("Locations");
		sh2_1.getChildren().add(loc);
		gpInsert.add(sh2_1, 1, 3);

		Label lblGender = new Label("Gender: ");
		lblGender.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		RadioButton male = new RadioButton("Male");
		male.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		RadioButton female = new RadioButton("Female");
		female.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		ToggleGroup group = new ToggleGroup();
		male.setToggleGroup(group);
		female.setToggleGroup(group);
		HBox ch = new HBox(10);
		ch.setPadding(new Insets(11, 12, 13, 14));
		ch.setAlignment(Pos.CENTER);
		ch.getChildren().addAll(male, female);
		gpInsert.add(lblGender, 0, 4);
		gpInsert.add(ch, 1, 4);

		Button btInsertM = new Button("Insert_Martyr");
		btInsertM.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpInsert.add(btInsertM, 1, 6);

// -------------------------------------------------------
		// This for update a martyr (pane in the right of the borderPane).

		GridPane gpUpdate = new GridPane();
		gpUpdate.setPadding(new Insets(11, 12, 13, 14));
		gpUpdate.setAlignment(Pos.CENTER);
		gpUpdate.setHgap(10);
		gpUpdate.setVgap(10);

		Label up = new Label();
		up.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));

		Label lblNameU = new Label("Name: ");
		lblNameU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfNameU = new TextField();
		gpUpdate.add(lblNameU, 0, 1);
		gpUpdate.add(tfNameU, 1, 1);

		Label lblAgeU = new Label("Age: ");
		lblAgeU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfAgeU = new TextField();
		gpUpdate.add(lblAgeU, 0, 2);
		gpUpdate.add(tfAgeU, 1, 2);

		Label lblDistrictU = new Label("District: ");
		lblDistrictU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpUpdate.add(lblDistrictU, 0, 3);
		StackPane sh1=new StackPane();
		sh1.getChildren().add(cbDistricts);
		gpUpdate.add(sh1, 1, 3);

		Label lblLocationU = new Label("Location: ");
		lblLocationU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpUpdate.add(lblLocationU, 0, 4);
		StackPane sh1_1=new StackPane();
		sh1_1.getChildren().add(cbLocations);
		gpUpdate.add(sh1_1, 1, 4);

		Label lblGenderU = new Label("Gender: ");
		lblGenderU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		RadioButton maleU = new RadioButton("Male");
		maleU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		RadioButton femaleU = new RadioButton("Female");
		femaleU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		ToggleGroup groupU = new ToggleGroup();
		maleU.setToggleGroup(groupU);
		femaleU.setToggleGroup(groupU);
		HBox chU = new HBox(10);
		chU.setPadding(new Insets(11, 12, 13, 14));
		chU.setAlignment(Pos.CENTER);
		chU.getChildren().addAll(maleU, femaleU);
		gpUpdate.add(lblGenderU, 0, 5);
		gpUpdate.add(chU, 1, 5);

		Button btUpdateU = new Button("Update_Martyr");
		btUpdateU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpUpdate.add(btUpdateU, 1, 7);

		VBox gpU = new VBox(10);
		gpU.setPadding(new Insets(11, 12, 13, 14));
		gpU.setAlignment(Pos.CENTER);
		gpU.getChildren().addAll(up, gpUpdate);

//-------------------------------------------------------------------------------

		BorderPane martyrTable = new BorderPane();

		TableView<MartyrRecord> table = new TableView<>();

		TableColumn<MartyrRecord, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, String>("name"));

		TableColumn<MartyrRecord, Integer> ageColumn = new TableColumn<>("Age");
		ageColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, Integer>("age"));

		TableColumn<MartyrRecord, String> locationColumn = new TableColumn<>("Location");
		locationColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, String>("location"));

		TableColumn<MartyrRecord, String> districtColumn = new TableColumn<>("District");
		districtColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, String>("district"));

		TableColumn<MartyrRecord, String> genderColumn = new TableColumn<>("Gender");
		genderColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, String>("gender"));

		table.getColumns().add(nameColumn);
		table.getColumns().add(ageColumn);
		table.getColumns().add(locationColumn);
		table.getColumns().add(districtColumn);
		table.getColumns().add(genderColumn);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		martyrTable.setCenter(table);

//-------------------------------------------------------------------------------
		// This pane in the center of the borderPane.

		StackPane pane4 = new StackPane();
		pane4.setPadding(new Insets(11, 12, 13, 14));
		Result = new TextArea();
		Result.setEditable(false);
		Result.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane4.getChildren().add(Result);

//-------------------------------------------------------------------------------
		// Add the all previous panes to borderPane(base pane).

		pane = new BorderPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setTop(pane1);
		pane.setLeft(pane2);
		pane.setRight(pane3);
		pane.setCenter(pane4);

// -------------------------------------------------------------------------
		// This to insert a new Location (it must a not exist location to add it).

		Stage InsertMscene = new Stage();
		Scene InsertMs = new Scene(gpInsert, 400, 350);

		btInsert.setOnAction(e -> {

			System.out.println("Insert Martyr Button clicked !\n");
			pane.setCenter(pane4);
			Result.setText("");

			InsertMscene.setTitle("Insert_Martyr_Screen");
			InsertMscene.setScene(InsertMs);
			InsertMscene.show();

			dis.setItems(cbDistricts.getItems());

			dis.setOnAction(ehi-> {

				loc.getItems().clear();

				if (dis.valueProperty().get()!=null) {

					SNode<String>curr=dis.valueProperty().get().getLocations().getHead();
					while (curr!=null) {

						loc.getItems().add(curr.getData());
						curr=curr.getNext();
					}
				}

			});

			btInsertM.setOnAction(eh -> {

//				if (tfName.getText()!=null && tfAge.getText()!=null && dis.getValue()!=null && loc.getValue()!=null && (male.isSelected()==true || female.isSelected()==true) ) {

					String name = tfName.getText();
					int age = Integer.parseInt(tfAge.getText());
					String district = dis.getValue().getDistrictName();

					String location = loc.getValue();

					String gender = "";
					if (male.isSelected()) {

						gender = "M";

					} else if (female.isSelected()) {

						gender = "F";
					}



					MartyrRecord martyr = new MartyrRecord(name, age, location, district, gender);

					MartyrRecord m=deleteM(martyrs,martyr);


					if (m == null) {

						martyrs.insert(martyr);
						Result.setText("Added Martyr successfully !\n\n");
						traverseInOrder(martyrs);

					} else {

						Result.setText("This Martyr is already exist");
					}

					tfName.clear();
					tfAge.clear();
					dis.setValue(null);
					loc.setValue(loc.getPromptText());
					male.setSelected(false);
					female.setSelected(false);

					InsertMscene.close();

//				}else {
//
//					Result.setText("Enter All information");
//
//					tfName.clear();
//					tfAge.clear();
//					dis.setValue(null);
//					loc.setValue(loc.getPromptText());
//					male.setSelected(false);
//					female.setSelected(false);
//					InsertMscene.close();
//
//				}
			});

		});

// ----------------------------------------------------------------------------------------
		// This to delete a Martyr (it must a exist martyr to delete it).

		btDelete.setOnAction(e -> {

			System.out.println("Delete Martyr Button clicked !\n");
			pane.setCenter(pane4);

			String name = tfDelete.getText();

			MartyrRecord martyr = new MartyrRecord(name, 0, "", "", "");

			MartyrRecord m=deleteM(martyrs, martyr);

			if (m != null) {

				alertW.setHeaderText("if you delete a martyr, you can't return to it again !! ");

				Optional<ButtonType> result1 = alertW.showAndWait();

				if (result1.isPresent() && result1.get() == ButtonType.OK && result1.get() != ButtonType.CLOSE) {

					alertC.setHeaderText("Are you sure to delete this martyr ?!");
					alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

					Optional<ButtonType> result = alertC.showAndWait();
					if (result.isPresent() && result.get() == ButtonType.OK && result.get() != ButtonType.CLOSE) {

						martyrs.delete(m);
						Result.setText("Delete a Martyr successfully !\n\n");
						traverseInOrder(martyrs);

					}

				}

			} else {

				Result.setText("This martyr is not exist to delete");
			}

			tfDelete.clear();
		});

// ---------------------------------------------------------------------
		// This to update a Martyr (it must a exist martyr to update it).

		Stage UpdateMscene = new Stage();
		Scene UpdateMs = new Scene(gpU, 400, 350);
		btUpdate.setOnAction(e -> {

			System.out.println("Update Martyr Button clicked !\n");
			pane.setCenter(pane4);
			Result.setText("");

			String name = tfUpdate.getText();

			MartyrRecord martyr = new MartyrRecord(name, 0, "", "", "");

			MartyrRecord m=UpdateM(martyrs, martyr);

			if (m != null) {

				up.setText("Update for " + martyr.getName());
				UpdateMscene.setTitle("Update_Martyr_Screen");
				UpdateMscene.setScene(UpdateMs);
				UpdateMscene.show();


				cbDistricts.setOnAction(ehi-> {

					cbLocations.getItems().clear();

					if (cbDistricts.valueProperty().get()!=null) {

						SNode<String>curr=cbDistricts.valueProperty().get().getLocations().getHead();
						while (curr!=null) {

							cbLocations.getItems().add(curr.getData());
							curr=curr.getNext();
						}
					}

				});


				btUpdateU.setOnAction(eh -> {

					String nameU = tfNameU.getText();
					int ageU = Integer.parseInt(tfAgeU.getText());
					String districtU = cbDistricts.getValue().getDistrictName();


					String locationU = cbLocations.getValue();
					String genderU = "";
					if (maleU.isSelected()) {

						genderU = "M";

					} else if (femaleU.isSelected()) {

						genderU = "F";
					}

					MartyrRecord martyrU = new MartyrRecord(nameU, ageU, locationU,districtU , genderU);

					alertW.setHeaderText("if you update a martyr, it will change his information !! ");

					Optional<ButtonType> result1 = alertW.showAndWait();

					if (result1.isPresent() && result1.get() == ButtonType.OK && result1.get() != ButtonType.CLOSE) {

						alertC.setHeaderText("Are you sure to Update this martyr ?!");
						alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

						Optional<ButtonType> result = alertC.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK && result.get() != ButtonType.CLOSE) {


							martyrs.delete(m);
							martyrs.insert(martyrU);

							Result.setText("Update martyr successfully !\n\n");
							traverseInOrder(martyrs);

						}

					}

					tfNameU.clear();
					tfAgeU.clear();
					cbDistricts.setValue(null);
					cbLocations.setValue(cbLocations.getPromptText());
					maleU.setSelected(false);
					femaleU.setSelected(false);

					UpdateMscene.close();

				});

			} else {

				Result.setText("This martyr is not exist to update !!");
			}

			tfUpdate.clear();
		});

// ---------------------------------------------------------------------

		btShow.setOnAction(e-> {

			System.out.println("Show Button clicked !\n");
			pane.setCenter(pane4);


			Result.setText("The size of the tree: "+martyrs.size()+"\n"+ "The height of the tree: "+martyrs.height());
		});

// ---------------------------------------------------------------------

		btPrint.setOnAction(e-> {

			System.out.println("Print tree Button clicked !\n");
			pane.setCenter(pane4);

			Result.setText("");

			if (martyrs.getRoot() != null) {

				LinkedQueue<TNode<MartyrRecord>> queue = new LinkedQueue<>();

				queue.enqueue(martyrs.getRoot());

				while (!queue.isEmpty()) {

					TNode<MartyrRecord> curr = queue.dequeue();

					Result.setText(Result.getText()+ curr + " ");

					if (curr.hasRight()) queue.enqueue(curr.getRight());
					if (curr.hasLeft()) queue.enqueue(curr.getLeft());

				}
			}

		});


		btPrintTable.setOnAction(e-> {

			System.out.println("Print table Button clicked !\n");

			MaxHeap<MartyrRecord>martyrHeap=new MaxHeap<>(martyrs.size());

			if (martyrs.getRoot() == null) return;

			LinkedQueue<TNode<MartyrRecord>> queue = new LinkedQueue<>();

			queue.enqueue(martyrs.getRoot());

			while (!queue.isEmpty()) {

				TNode<MartyrRecord> curr = queue.dequeue();

				martyrHeap.add(curr.getData());

				if (curr.hasLeft()) queue.enqueue(curr.getLeft());
				if (curr.hasRight()) queue.enqueue(curr.getRight());
			}

			martyrHeap.heapSortAsc();

			table.getItems().clear();
			for (int i=1; i<= martyrHeap.getSize(); i++) {

				table.getItems().add(martyrHeap.get(i));
			}


			pane.setCenter(martyrTable);

		});

	}

	public BorderPane getPane() {
		return pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}

	public Avl_tree<MartyrRecord> getMartyrs() {
		return martyrs;
	}

	public void setMartyrs(Avl_tree<MartyrRecord> martyrs) {
		this.martyrs = martyrs;
	}

	public ComboBox<DistrictRecord> getCbDistricts() {
		return cbDistricts;
	}

	public void setCbDistricts(ComboBox<DistrictRecord> cbDistricts) {
		this.cbDistricts = cbDistricts;
	}

	public void traverseInOrder(Avl_tree<MartyrRecord> martyrs) {
		traverseInOrder(martyrs.getRoot());
	}

	private void traverseInOrder(TNode<MartyrRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)
				traverseInOrder(node.getLeft());

			Result.setText(Result.getText() + node);

			if (node.getRight() != null)
				traverseInOrder(node.getRight());
		}
	}

	private MartyrRecord deleteM(Avl_tree<MartyrRecord> martyrs, MartyrRecord martyr) {

		if (martyrs.getRoot() == null)
			return null;

		LinkedQueue<TNode<MartyrRecord>> queue = new LinkedQueue<>();

		queue.enqueue(martyrs.getRoot());

		while (!queue.isEmpty()) {

			TNode<MartyrRecord> node = queue.dequeue();


			if (node.getData().equals(martyr)) {

				return node.getData();
			}


			if (node.hasLeft())
				queue.enqueue(node.getLeft());
			if (node.hasRight())
				queue.enqueue(node.getRight());
		}

		return null;
	}

	public MartyrRecord UpdateM(Avl_tree<MartyrRecord> martyrs, MartyrRecord martyr) {

		if (martyrs.getRoot() == null)
			return null;

		LinkedQueue<TNode<MartyrRecord>> queue = new LinkedQueue<>();

		queue.enqueue(martyrs.getRoot());

		while (!queue.isEmpty()) {

			TNode<MartyrRecord> node = queue.dequeue();

			if (node.getData().equals(martyr)) {

				return node.getData();
			}

			if (node.hasLeft())
				queue.enqueue(node.getLeft());
			if (node.hasRight())
				queue.enqueue(node.getRight());
		}

		return null;
	}

}
