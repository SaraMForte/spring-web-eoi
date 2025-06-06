package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.domain.Office;

import java.util.List;

public interface OfficeService {
    List<Office> findBasicAddress();
}
