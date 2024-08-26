package models.statePattern;

import java.io.File;
import java.io.IOException;

import controllers.BanVeController;
import controllers.ChonSuatChieuController;
import controllers.DatVeController;
import controllers.ThongTinVeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.LichChieu;
import models.Phim;
import models.Rap;
import models.UserData;

public class ChonSuatChieuState implements StateDatVe {
    private final DatVeController context;

    public ChonSuatChieuState(DatVeController context) {
        this.context = context;
    }

    @Override
    public void handleStep() {
        try {
            // Set booking data
            setupBookingData();

            // Clear current view and load new areas
            context.getMainPane().getChildren().remove(0);
            loadThongTinVeArea();
            updateThongTinVeArea();
            loadChonSuatChieuArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupBookingData() {
        Phim bookingPhim = (Phim) UserData.getInstance().getData("bookingPhim");
        Rap selectedRap = BanVeController.getInstance().getSelectedRap();
        String selectedNgayChieu = BanVeController.getInstance().getSelectedNgayChieu();
        LichChieu bookingLichChieu = new LichChieu(selectedRap, selectedNgayChieu);
        DatVe datVe = new DatVe(bookingLichChieu, bookingPhim);
        context.setDatVe(datVe);
    }

    private void loadThongTinVeArea() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ThongTinVeController.FXML));
        VBox thongTinVeArea = fxmlLoader.load();
        ThongTinVeController thongTinVeController = fxmlLoader.getController();
        context.setThongTinVeController(thongTinVeController);
        context.setThongTinVeArea(thongTinVeArea);
        context.getMainPane().getChildren().add(0, thongTinVeArea);
    }

    private void updateThongTinVeArea() {
        ThongTinVeController thongTinVeController = context.getThongTinVeController();
        DatVe datVe = context.getDatVe();
        Phim bookingPhim = datVe.getBookingPhim();
        LichChieu bookingLichChieu = datVe.getBookingLichChieu();

        // Load and set image
        File file = new File(bookingPhim.getHinhAnh());
        Image image = new Image(file.toURI().toString());
        thongTinVeController.getImageView().setImage(image);

        // Set labels
        thongTinVeController.getTenPhimLbl().setText(bookingPhim.getTenPhim());
        thongTinVeController.getTenRapLbl().setText(bookingLichChieu.getRap().getTenRap());
        thongTinVeController.getNgayChieuLbl().setText(bookingLichChieu.getNgaychieu());
    }

    private void loadChonSuatChieuArea() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ChonSuatChieuController.FXML));
        VBox chonSuatChieuView = fxmlLoader.load();
        context.getStepDatVeArea().getChildren().clear();
        context.getStepDatVeArea().getChildren().add(chonSuatChieuView);
    }
}
