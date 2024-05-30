package models.statePattern;

import java.io.File;

import controllers.ChonSuatChieuController;
import controllers.DatVeController;
import controllers.ThongTinVeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.LichChieu;
import models.Phim;

public class ChonSuatChieuState implements StateDatVe {
    private DatVeController context;

    public ChonSuatChieuState(DatVeController context) {
        this.context = context;
    }

    @Override
    public void handleStep() {
        context.getMainPane().getChildren().remove(0);
        try {
            loadThongTinVeArea();
            updateThongTinVeArea();
            loadChonSuatChieuArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadThongTinVeArea() throws java.io.IOException {
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
        
        File file = new File(bookingPhim.getHinhAnh());
        Image image = new Image(file.toURI().toString());
        
        thongTinVeController.getImageView().setImage(image);
        thongTinVeController.getTenPhimLbl().setText(bookingPhim.getTenPhim());
        thongTinVeController.getTenRapLbl().setText(bookingLichChieu.getRap().getTenRap());
        thongTinVeController.getNgayChieuLbl().setText(bookingLichChieu.getNgaychieu());
    }

    private void loadChonSuatChieuArea() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ChonSuatChieuController.FXML));
        VBox chonSuatChieuView = fxmlLoader.load();
        context.getStepDatVeArea().getChildren().clear();
        context.getStepDatVeArea().getChildren().add(chonSuatChieuView);
    }
}
