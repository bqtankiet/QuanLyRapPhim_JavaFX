package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.AlertDialog;
import utils.PaneController;

public class ThemPhimController implements Initializable {
	public static final String FXML = "/views/phim/themphim.fxml";
	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button chonFileBtn;

	@FXML
	private TextField daoDienField;

	@FXML
	private TextField dienVienField;

	@FXML
	private TextField doTuoiField;

	@FXML
	private Button huyBtn;

	@FXML
	private TextArea moTaTextArea;

	@FXML
	private DatePicker ngayKhoiChieuDatepicker;

	@FXML
	private TextField quocGiaField;

	@FXML
	private TextField tenPhimField;

	@FXML
	private TextField theLoaiField;

	@FXML
	private TextField thoiLuongField;

	@FXML
	private Button xacnhanBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ngayKhoiChieuDatepicker.setValue(LocalDate.now());
		huyBtn.setOnAction(event -> huyBtnAction());
		xacnhanBtn.setOnAction(event -> xacnhanBtnAction());
	}

	/**
	 * Phương thức này xử lý sự kiện khi nhấn vào button "Xác nhận" <br>
	 * Đây là functional interface của EventHandler
	 */
	private Object xacnhanBtnAction() {
		boolean passed = kiemTraThongTin();
		if (passed) {
			boolean confirm = AlertDialog.showConfirmAlert("Bạn có chắc muốn thêm phim mới?");
			if (confirm) {
				// TODO Yêu cầu thêm xử lý sự kiện thêm phim mới vào CSDL
				System.out.println("Them phim moi");
			}
		}
		return null;
	}

	/**
	 * Phương thức này xử lý sự kiện khi nhấn vào button "Hủy" <br>
	 * Đây là functional interface của EventHandler
	 */
	private Object huyBtnAction() {
//		try {
//			Pane replacePane = FXMLLoader.load(getClass().getResource(PhimController.FXML));
//			BorderPane parent = (BorderPane) rootPane.getParent();
//			parent.setCenter(replacePane);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		PaneController.getInstance().replacePane(this.rootPane, PhimController.FXML);
		return null;
	}

	/**
	 * Phương thức này kiểm tra xem các thông tin phim có bị bỏ trống hay không?
	 * <br>
	 * - Nêu bị bỏ trống thì thông báo và trả về false <br>
	 * - Nếu đã điều đầy đủ thì trả về true
	 */
	private boolean kiemTraThongTin() {
		boolean result = true;
		ArrayList<TextField> fields = new ArrayList<>();
		fields.addAll(Arrays.asList(tenPhimField, quocGiaField, theLoaiField, thoiLuongField, daoDienField,
				dienVienField, doTuoiField));
		for (TextField tf : fields) {
			if (tf.getText().isBlank()) {
				tf.clear();
				tf.setPromptText("Không được để trống");
				result = false;
			}
		}
		if (ngayKhoiChieuDatepicker.getValue() == null) {
			ngayKhoiChieuDatepicker.setPromptText("Không được để trống");
			result = false;
		}
		return result;
	}
}
