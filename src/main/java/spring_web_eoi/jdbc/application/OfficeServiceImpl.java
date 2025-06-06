package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.domain.Office;

import java.util.List;

public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }


    @Override
    public List<Office> findBasicAddress() {
        return officeRepository.findBasicAddress();
    }
}
