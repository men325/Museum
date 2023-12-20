package spring.mvc_hibernate_aop.data_processing_functions;

import org.springframework.validation.BindingResult;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Guide;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.service.GuideService;
import spring.mvc_hibernate_aop.service.HallService;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerDataProcessing {
    //    ---------------------------Функция обработки входных данных при добавлении картинки-----------------------------//
    public static String ProcessingPictureDataAndOperatingWithFiles(File file, Museum museum) {

        String museumLastName = museum.getBase64Image();
        String path = file.getName();
        String nameToSaveInDB = Randomizer(path);

        //Удаление прошлой картинки
        if (museumLastName.length() > 1 && !Objects.equals(museumLastName, path)) {
            File imageToDELETE = new File("C:\\Users\\x4pla\\GIT\\CursProject\\Museum\\src\\main\\webapp\\resources\\img\\" + museumLastName);
            System.out.println("File: " + imageToDELETE + " | Status: DELETED");
            imageToDELETE.delete();
        }

        //Копирование файла из рабочего стола в папку ../resources/img
        try {
            File source = new File("C:\\Users\\x4pla\\Desktop\\" + path);
            File dest = new File("C:\\Users\\x4pla\\GIT\\CursProject\\Museum\\src\\main\\webapp\\resources\\img\\" + nameToSaveInDB);
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        //Возвращаем строку, которую занесем в БД, как название нашей картинки
        return nameToSaveInDB;
    }

    public static String Randomizer(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            int rand = new Random().nextInt(52);
            char start = (rand < 26) ? 'A' : 'a';
            char c = (char) (start + rand % 26);
            stringBuilder.append(c);
        }
        stringBuilder.insert(0, s);
        System.out.println("SB: " + stringBuilder);
        return String.valueOf(stringBuilder);
    }

    //    ---------------------------Функция обработки входных данных при добавлении екскурсии и залов к ней-----------------------------//

    public Excursion processHallIdsFromCheckboxesAndSaveHallsToExcursion(BindingResult bindingResult, Excursion excursion, HallService hallService, MuseumService museumService, GuideService guideService) {
        List <Hall> oldHallList = hallService.getAllHallsWithThisExcursionID(excursion.getId_excursion());
        //Получаем hallList в виде строки. Парсим строку, получаем айдишники залов и находим их. Затем создаем массив из этих же ID
        String stringOfChosenHalls = (String) bindingResult.getFieldValue("hallList");

        Pattern pattern = Pattern.compile(("(ID=)(\\d+)"));
        assert stringOfChosenHalls != null;
        Matcher matcher = pattern.matcher(stringOfChosenHalls);
        ArrayList <Integer> integerArrayListOfIds = new ArrayList <>();
        while (matcher.find()) {
            int idFromString = Integer.parseInt(matcher.group(2));
            integerArrayListOfIds.add(idFromString);
        }

        //Создаем список из залом, и тут мы добавляем в список залов екскурсии все найденые залы.
        List <Hall> newHallListToBeSaved = new ArrayList <>();
        for (Integer integer : integerArrayListOfIds) {
            Hall hall = hallService.findHall(integer);
            excursion.addHallToExcursion(hall);
            newHallListToBeSaved.add(hall);
        }

        //Тут мы отвязываем залы, которые не были выбраны в селекторе, от екскурсии. То есть-ставим в поле hall_excursion_id = NULL

        System.out.println("OLD HALL LIST:-----------------> " + oldHallList);
        System.out.println("////////////////////////////////////////");
        List <Hall> hallListToSetNULL = hallListFILTEREDTODELETE(oldHallList, newHallListToBeSaved);
        System.out.println("NEW HALL LIST:------> " + newHallListToBeSaved);
        System.out.println("////////////////////////////////////////");
        System.out.println("hallListFILTEREDTODELETE:------> " + hallListToSetNULL);
        for (Hall hall : hallListToSetNULL) {
            hallService.setExcursionIdNUllToThisHall(hall);
        }

        //Добавляем ОДИН музей к нашей новосозданной екскурсии
        int musId = excursion.getHallList().get(0).getMuseum().getMuseum_id();
        Museum museum = museumService.findMuseum(musId);
        excursion.setMuseum(museum);

        //Добавляем ОДНОГО гида к нашей новосозданной екскурсии
        int guidesId = excursion.getGuide().getGuide_id();
        Guide guide = guideService.findGuide(guidesId);
        excursion.setGuide(guide);

        return excursion;
    }

    public static List <Hall> hallListFILTEREDTODELETE(List <Hall> oldHallList, List <Hall> newHallList) {

        List <Hall> TARMINATED_HALL_LIST = new ArrayList <>();
        int DROP;
        for (Hall value : oldHallList) {
            int hall_id = value.getHall_id();
            DROP = 0;
            for (Hall hall : newHallList) {
                if (hall_id == hall.getHall_id()) {
                    DROP = 1;
                    //i++;
                    break;
                }
            }
            if (DROP == 0) {
                TARMINATED_HALL_LIST.add(value);
            }
        }
        return TARMINATED_HALL_LIST;
    }


}
