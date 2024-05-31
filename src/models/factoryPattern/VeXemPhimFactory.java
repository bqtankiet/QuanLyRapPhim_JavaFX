package models.factoryPattern;

import models.DatVe;
import models.VeXemPhim;

public interface VeXemPhimFactory {
	VeXemPhim createVeXemPhim(DatVe datVe);
}
