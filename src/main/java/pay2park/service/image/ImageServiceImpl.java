package pay2park.service.image;

//@Service
public class ImageServiceImpl {//implements ImageService {
//    @Autowired
//    ParkingLotImageRepository parkingLotImageRepository;
//    @Autowired
//    CloudinaryService cloudinaryService;
//    @Autowired
//    ParkingLotRepository parkingLotRepository;
//    @Override
//    public ResponseObject getOneImage(String id) {
//        Optional<ParkingLotImage> parkingLotImage = parkingLotImageRepository.findById(id);
//        return parkingLotImage.map(lotImage -> new ResponseObject(HttpStatus.OK, "Success", lotImage))
//                .orElseGet(() -> new ResponseObject(HttpStatus.FOUND, "ID is not valid", ""));
//    }
//    @Override
//    public ResponseObject getAllImageByParkingLot(int parkingLotId) {
//        if(!checkParkingLotID(parkingLotId)) {
//            return new ResponseObject(HttpStatus.FOUND, "Parking lot ID is not valid", "");
//        }
//        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotId);
//        List<ParkingLotImage> responseData = parkingLotImageRepository.getAllImageByParkingLot(parkingLot.get());
//        return new ResponseObject(HttpStatus.OK, "Success", responseData);
//    }
//    @Override
//    public void insertImage(MultipartFile multipartFile) {
////        cloudinaryService.uploadImage()
////        parkingLotImageRepository.save(image);
//    }
//    @Override
//    public void deleteImage(String id) {
//        parkingLotImageRepository.deleteById(id);
//    }
//    @Override
//    public boolean isExists(String id) {
//        return parkingLotImageRepository.existsById(id);
//    }
//    private boolean checkParkingLotID(int parkingLotID) {
//        return parkingLotRepository.existsById(parkingLotID);
//    }
}
