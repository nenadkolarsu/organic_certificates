package controller;

import service.SertifikatManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.FileBucket;
import model.Kupac;
import model.LoginBean;
import model.ProizvodjacDocument;
import model.Sertifikati;
import model.User;
import model.WhereUslov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.Dao;

@Controller
public class SpringMVCController {

    @RequestMapping(value = "/helloWorld.web", method
            = RequestMethod.GET)
    public String printWelcome(@ModelAttribute("person") Person person, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "helloWorld";
    }

    @RequestMapping(value = "/login.web", method
            = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    @RequestMapping(value = "/login.web", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
            if (loginBean.getUserName().equals("demo") && loginBean.getPassword().equals("demo")) {
                model.addAttribute("success", "welcome " + loginBean.getUserName());
                return "dobroDosli";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }

    @RequestMapping(value = {"/pocetna.web", "/list.web", "/"}, method
            = RequestMethod.GET)
    public String printPocetna(@ModelAttribute("person") Person person, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "pocetna";
    }

    @RequestMapping(value = "/stranaSertifikata.web", method
            = RequestMethod.GET)
    public String printStranaSertifikata(@ModelAttribute("person") Person person,
            BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "stranaSertifikata";
    }

    @RequestMapping(value = "/DrugaStranaSertifikata.web", ///{id}
            method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String DrugaStranaSertifikata(HttpServletRequest request, @PathVariable("id") int id) throws IOException {//  

        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart")) {
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / 10) + 1;
        }

        String searchParameter = request.getParameter("sSearch");

        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));

        List<Sertifikati> personsListS = createPaginationDataDruga(pageDisplayLength, id);//, id

        if (pageNumber == 1) {
            Collections.shuffle(personsListS);
        } else if (pageNumber == 2) {
            Collections.shuffle(personsListS);
        } else {
            Collections.shuffle(personsListS);
        }

        personsListS = getListBasedOnSearchParameterDruga(searchParameter, personsListS);
        SertifikatJsonObject personJsonObject = new SertifikatJsonObject();
        personJsonObject.setiTotalDisplayRecords(personsListS.size()); // 500
        personJsonObject.setiTotalRecords(personsListS.size()); // 500
        personJsonObject.setAaData(personsListS);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(personJsonObject);

        return json2;
    }

    private List<Sertifikati> createPaginationDataDruga(Integer pageDisplayLength, Integer proizvodjac_id) {// 

        List<Sertifikati> personsList = new ArrayList<Sertifikati>();

        SertifikatManager a = new SertifikatManager();
        Sertifikati bb = a.vratiSertifikat(proizvodjac_id);
        return personsList;
    }

    @RequestMapping(value = "/sablon.web", method
            = RequestMethod.GET)
    public String printSablon(@ModelAttribute("person") Person person, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "sablon";
    }

    @RequestMapping(value = "/springPaginationDataTables.web",
            method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String springPaginationDataTables(HttpServletRequest request) throws IOException {

        //Fetch the page number from client
        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart")) {
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / 10) + 1;
        }

        //Fetch search parameter
        String searchParameter = request.getParameter("sSearch");

        //Fetch Page display length
        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));

        //Create page list data
        List<Person> personsList = createPaginationData(pageDisplayLength);

        //Here is server side pagination logic. Based on the page number you could make call 
        //to the data base create new list and send back to the client. For demo I am shuffling 
        //the same list to show data randomly
        if (pageNumber == 1) {
            Collections.shuffle(personsList);
        } else if (pageNumber == 2) {
            Collections.shuffle(personsList);
        } else {
            Collections.shuffle(personsList);
        }

        // Search functionality: Returns filtered list based on search parameter
        personsList = getListBasedOnSearchParameter(searchParameter, personsList);

        PersonJsonObject personJsonObject = new PersonJsonObject();
        // Set Total display record
        personJsonObject.setiTotalDisplayRecords(500);
        // Set Total record
        personJsonObject.setiTotalRecords(500);
        personJsonObject.setAaData(personsList);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(personJsonObject);

        return json2;
    }

    @RequestMapping(value = "/springPaginationDataTablesPocetna.web",
            method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String springPaginationDataTablesPocetna(HttpServletRequest request) throws IOException {

        //Fetch the page number from client
        Integer pageNumber = 0;
        List<Sertifikati> deoListe = null;
        String aaa = request.getParameter("iDisplayStart");
        if (null != request.getParameter("iDisplayStart")) {
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / 10) + 1;
        }

        //Fetch search parameter
        String searchParameter = request.getParameter("sSearch");
        String bbb = request.getParameter("iDisplayLength");
        //Fetch Page display length
        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));

        //Create page list data
        List<Sertifikati> personsListS = createPaginationDataPocetna(pageDisplayLength);
        Integer brojRekorda = personsListS.size();

        //Here is server side pagination logic. Based on the page number you could make call 
        //to the data base create new list and send back to the client. For demo I am shuffling 
        //the same list to show data randomly
        deoListe = personsListS.subList(pageNumber * 10 - 10, brojRekorda > (pageNumber * 10) ? pageNumber * 10 : brojRekorda);
        //Search functionality: Returns filtered list based on search parameter
        personsListS = getListBasedOnSearchParameterPocetna(searchParameter, personsListS);

        SertifikatJsonObject personJsonObject = new SertifikatJsonObject();
        //Set Total display record
        personJsonObject.setiTotalDisplayRecords(personsListS.size()); // 500
        //Set Total record
        personJsonObject.setiTotalRecords(personsListS.size()); // 500
//		personJsonObject.setAaData(personsListS);
        if (searchParameter.length() >= 1) { // ako je trazio daj mu rezultat 
            personJsonObject.setAaData(personsListS);
        } else {
            personJsonObject.setAaData(deoListe); // inace mu daj samo 10
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(personJsonObject);

        return json2;
    }

    private List<Sertifikati> getListBasedOnSearchParameterDruga(String searchParameter, List<Sertifikati> personsList) {

        if (null != searchParameter && !searchParameter.equals("")) {
            List<Sertifikati> personsListForSearch = new ArrayList<Sertifikati>();
            searchParameter = searchParameter.toUpperCase();
            for (Sertifikati person : personsList) {
                if (person.getProizvodjac().toUpperCase().indexOf(searchParameter) != -1 || person.getAdresa().toUpperCase().indexOf(searchParameter) != -1
                        || person.getMesto().toUpperCase().indexOf(searchParameter) != -1 || person.getZemlja().toUpperCase().indexOf(searchParameter) != -1) //		|| person.getSalary().toUpperCase().indexOf(searchParameter)!= -1 || person.getStart_date().toUpperCase().indexOf(searchParameter)!= -1)
                {
                    personsListForSearch.add(person);
                }

            }
            personsList = personsListForSearch;
            personsListForSearch = null;
        }
        return personsList;
    }

    private List<Sertifikati> getListBasedOnSearchParameterPocetna(String searchParameter, List<Sertifikati> personsList) {
        String rr = null;
        if (null != searchParameter && !searchParameter.equals("")) {
            List<Sertifikati> personsListForSearch = new ArrayList<Sertifikati>();
            searchParameter = searchParameter.toUpperCase();

            for (Sertifikati person : personsList) {
                rr = person.getProizvodjac().toUpperCase();
                if (person.getProizvodjac().toUpperCase().indexOf(searchParameter) != -1 || person.getAdresa().toUpperCase().indexOf(searchParameter) != -1
                        || person.getMesto().toUpperCase().indexOf(searchParameter) != -1 || person.getZemlja().toUpperCase().indexOf(searchParameter) != -1) //		|| person.getSalary().toUpperCase().indexOf(searchParameter)!= -1 || person.getStart_date().toUpperCase().indexOf(searchParameter)!= -1)
                {
                    personsListForSearch.add(person);
                }

            }
            personsList = personsListForSearch;
            personsListForSearch = null;
        }
        return personsList;
    }

    private List<Person> getListBasedOnSearchParameter(String searchParameter, List<Person> personsList) {

        if (null != searchParameter && !searchParameter.equals("")) {
            List<Person> personsListForSearch = new ArrayList<Person>();
            searchParameter = searchParameter.toUpperCase();
            for (Person person : personsList) {
                if (person.getName().toUpperCase().indexOf(searchParameter) != -1 || person.getOffice().toUpperCase().indexOf(searchParameter) != -1
                        || person.getPhone().toUpperCase().indexOf(searchParameter) != -1 || person.getPosition().toUpperCase().indexOf(searchParameter) != -1
                        || person.getSalary().toUpperCase().indexOf(searchParameter) != -1 || person.getStart_date().toUpperCase().indexOf(searchParameter) != -1) {
                    personsListForSearch.add(person);
                }

            }
            personsList = personsListForSearch;
            personsListForSearch = null;
        }
        return personsList;
    }

    private List<Sertifikati> createPaginationDataPocetna(Integer pageDisplayLength) {
        List<Sertifikati> personsList = new ArrayList<Sertifikati>();

        SertifikatManager a = new SertifikatManager();
        List<Sertifikati> bb = a.getSertifikatList();

        for (int i = 0; i < bb.size(); i++) {
//                     <a href=prikazSertifikata.web?id=" + "1" + ">
            Sertifikati kupac = (Sertifikati) bb.get(i);
//			System.out.println(crunchifyList.get(i));
            Sertifikati person2 = new Sertifikati();

            person2.setId(kupac.getId());
            person2.setProizvodjac("<a href=\"sertifikatiZaProizvodjaca.web?id=" + kupac.getId() + "\"> " + kupac.getProizvodjac() + "</a>");
            person2.setAdresa(kupac.getAdresa());;
            person2.setMesto(kupac.getMesto());
            person2.setZemlja(kupac.getZemlja());
            person2.setRezerva2(Integer.toString(a.vratiBrojSertifikataKojeImaProizvodjac(kupac.getId())));

//                    <a href="index.html" class="logo"><img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System"></a>
//	            person2.setZemlja("9999");   
// "<img border=\"0\" alt=\"W3Schools\" src=\"${cp}/resources/images/logo_w3s.gif\" width=\"100\" height=\"100\">\n" +
// "</a>"); 
//       < img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System">
//	            person2.setStart_date("05/05/2010");
//                    person2.setDokument("<a href=prikazSertifikata.web?id=" + "1" + ">Prikaz</a>"); // person2.getPhone()
            //       http://www.ethicalsuperstore.com/images/icons/icon-parent-organic.png http://www.ethicalsuperstore.com/images/icons/icon-parent-organic.png https://hikashop.com/media/com_hikashop/upload/thumbnails/210x210/pdf.png
            //                  person2.setRezerva1("<a href=sertifikatiZaProizvodjaca.web?id=" + "1" + "><img src=\"http://www.ethicalsuperstore.com/images/icons/icon-parent-organic.png\" width=\"40\" height=\"30\" ></a> "); // person2.getPhone()
            person2.setRezerva1("<a href=\"sertifikatiZaProizvodjaca.web?id=" + kupac.getId() + "\"> " + "<img src=\"http://www.ethicalsuperstore.com/images/icons/icon-parent-organic.png\" width=\"40\" height=\"30\" ></a>");

//                    person2.setDokument("f.pdf");
            personsList.add(person2);
        }

        return personsList;
    }

    private List<Person> createPaginationData(Integer pageDisplayLength) {
        List<Person> personsList = new ArrayList<Person>();

        CustomerManager a = new CustomerManager();
        List<Kupac> bb = a.getKupacList();

        for (int i = 0; i < bb.size(); i++) {

            Kupac kupac = (Kupac) bb.get(i);
//			System.out.println(crunchifyList.get(i));
            Person person2 = new Person();
            person2.setName(kupac.getName());
            person2.setPosition(kupac.getMaticni_broj());
            person2.setSalary(kupac.getMesto());
            person2.setOffice("NY");
//                    <a href="index.html" class="logo"><img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System"></a>
            person2.setPhone("9999");
// "<img border=\"0\" alt=\"W3Schools\" src=\"${cp}/resources/images/logo_w3s.gif\" width=\"100\" height=\"100\">\n" +
// "</a>"); 
//       < img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System">
            person2.setStart_date("05/05/2010");
//                    person2.setDokument("<a href=prikazSertifikata.web?id=" + "1" + ">Prikaz</a>"); // person2.getPhone()
            //       http://www.ethicalsuperstore.com/images/icons/icon-parent-organic.png
            person2.setDokument("<a href=prikazSertifikata.web?id=" + "1" + "><img src=\"https://hikashop.com/media/com_hikashop/upload/thumbnails/210x210/pdf.png\" width=\"40\" height=\"30\" ></a> "); // person2.getPhone()
//                    person2.setDokument("f.pdf");
            personsList.add(person2);
        }

        return personsList;
    }

    @RequestMapping(value = "prikazSertifikata.web", method = RequestMethod.GET)
    public void doDownload(@RequestParam(value = "id") String id,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get absolute path of the application
        ServletContext context = request.getSession().getServletContext();
        String appPath = context.getRealPath("");
        String filename = request.getParameter("filename");
        String lessonName;
        System.out.println("aktuelni path user.dir : " + System.getProperty("user.dir"));
        System.out.println("appPath : " + appPath);
//   String filePath = getDownloadFilePath(lessonName);
        String filePath = System.getProperty("user.dir");

        // construct the complete absolute path of the file
//   String fullPath = appPath + filePath;  
        String fullPath = filePath + "/webapps/" + id + ".pdf";
        System.out.println("konacni path za pdf-e: " + fullPath);

        File f = new File(fullPath);
        if (f.exists() && !f.isDirectory()) {
        } else {
            id = "0";
            fullPath = filePath + "/webapps/" + id + ".pdf";
        }
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/pdf";
        }
        System.out.println("MIME type: " + mimeType);

        String headerKey = "Content-Disposition";

//   response.addHeader("Content-Disposition", "attachment;filename=report.pdf");
        response.setContentType("application/pdf");

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
    }

    @RequestMapping(value = "/kupac.web", method = RequestMethod.GET)
    public ModelAndView getKupac(@ModelAttribute("user") User newBudget, ModelMap mapBudget) {
        CustomerManager kupacManager = new CustomerManager();

        ModelAndView modelAndView = new ModelAndView("kupac");
        modelAndView.addObject("kupac", kupacManager.getKupacList());

        return modelAndView;
    }

    @RequestMapping(value = "/sertifikatiZaProizvodjaca.web", method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false) String id, HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {

        SertifikatManager sertifikatManager = new SertifikatManager();
        String proizvodjac = null;
        String adresa = null, mesto = null;
        List<Sertifikati> b;
        if (id == null) {
            b = sertifikatManager.getSertifikatList();
        } else {
            b = sertifikatManager.getListaProizvodjacaString(id);
//         		System.out.println("==> For Loop Example.");
            for (int i = 0; i < b.size(); i++) {
                System.out.println(b.get(i));
                Sertifikati naziv1 = (Sertifikati) b.get(i);
                proizvodjac = naziv1.getProizvodjac();
                adresa = naziv1.getAdresa();
                mesto = naziv1.getMesto();
            }
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("sertifikatiZaProizvodjaca");
        mav.addObject("proizvodjac", proizvodjac);
        mav.addObject("adresa", adresa);
        mav.addObject("mesto", mesto);

        List<ProizvodjacDocument> c = sertifikatManager.getListaSertifikataZaProizvodjacaString(id);
        mav.addObject("kupac", c);

        return mav;
    }

    @RequestMapping(value = "/kupacKriterijum.web", method = RequestMethod.GET)
    public String getKupacKriterijum(@RequestParam(required = false) String id, HttpServletRequest request) {

        SertifikatManager sertifikatManager = new SertifikatManager();
        List<Sertifikati> b;
        if (id == null) {
            b = sertifikatManager.getSertifikatList();
        } else {
            b = sertifikatManager.getListaProizvodjacaString(id);
        }

        request.setAttribute("kupac", b);
        // return modelAndView;
        return ("kupac");
    }

    @RequestMapping(value = "/kupacEdit.web", method = RequestMethod.GET)
    public ModelAndView kupacEdit(@RequestParam(value = "id") String id, ModelMap map) {

        Integer mId = Integer.parseInt(id);
        Kupac kupac = new Kupac();

        CustomerManager kupacManager = new CustomerManager();
        ModelAndView modelAndView = new ModelAndView("kupac");

        return new ModelAndView("kupacEdit", "kupac", kupacManager.vratiKupca(mId));
        // return "kupacEdit";
    }

    @RequestMapping(value = "/sertifikatiZaProizvodjaca.web")
    public String printWelcome2(@ModelAttribute("sertifikati") Sertifikati sertifikati,
            BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        SertifikatManager sertifikatManager = new SertifikatManager();
        ModelAndView modelAndView = new ModelAndView("sertifikati");
        modelAndView.addObject("sertifikati", sertifikatManager.getSertifikatList());
        return "sertifikatiZaProizvodjaca";
//         return modelAndView;
    }

    @RequestMapping(value = "/azuriranje.web", method = RequestMethod.GET)
    public String listaSertifikata(@RequestParam(required = false) String id, HttpServletRequest request, Model model) {
        String whereUslov = "";
        if (id == null) {
            whereUslov = " "; //b = sertifikatManager.getSertifikatList();
        } else {
            whereUslov = " where id like '%" + id + "%'" + " or proizvodjac like '%" + id + "%'" + " or mesto like '%" + id + "%'"; //b = sertifikatManager.getListaProizvodjacaString(id);   
        }

        Dao dao = new Dao();
        List<Sertifikati> sertifikati = dao.getAllSertifikati(whereUslov);

        model.addAttribute("sertifikat", new Sertifikati());
        model.addAttribute("users", sertifikati); // this.sertifikatService.listSertifikats());

        return "sertifikatsList";
    }

    @RequestMapping(value = "/azuriranje.web", method = RequestMethod.POST)
//    public String listaProizvodjaca(Model model, @ModelAttribute("whereUslov") LoginBean loginBean) {
    public String listaProizvodjaca(Model model, @ModelAttribute("whereUslov") WhereUslov whereUslov) {
        if (whereUslov != null && whereUslov.getWhereUslov() != null) {
//            if (loginBean.getUserName().equals("demo") && loginBean.getPassword().equals("demo")) {
            model.addAttribute("id", whereUslov.getWhereUslov());
            return "redirect:/azuriranje.web";
        } else {
            return "sertifikatsList";
        }
    }

    @RequestMapping(value = {"/edit-user-{id}.web"}, method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable String id, ModelMap model) {

        SertifikatManager sertifikatmanager = new SertifikatManager();
        List<Sertifikati> b;
// napuni klasu pa je prosledi u registration
        b = sertifikatmanager.getListaProizvodjacaString(id);
        Sertifikati a;

        a = sertifikatmanager.vratiSertifikat(new Integer(id));

        ModelAndView mav = new ModelAndView();

        mav.setViewName("registration");
        mav.addObject("sertifikati", a);
        mav.addObject("userList", b);
        mav.addObject("edit", true);

        return mav;
    }

    @RequestMapping(value = {"/edit-user-{id}.web"}, method = RequestMethod.POST)
    public String updateUser(Sertifikati sertifikati, BindingResult result,
            ModelMap model, @PathVariable String id) {

        if (result.hasErrors()) {
            return "registration";
        }

        SertifikatManager sertifikatmanager = new SertifikatManager();
        System.out.println(sertifikati.getProizvodjac());
        Dao dao = new Dao();
        dao.updateSertifikati(sertifikati);
//		userService.updateUser(user);

        model.addAttribute("user", sertifikati);
        model.addAttribute("success", "Proizvođač: " + sertifikati.getProizvodjacId() + " - "
                + sertifikati.getProizvodjac()
                + " - " + sertifikati.getAdresa() + " je uspešno izmenjen");
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/delete-user-{id}.web"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id, ModelMap model) {
        Dao dao = new Dao();

        Sertifikati a;
        int i = Integer.parseInt(id);
        a = dao.getSertifikatiById(i);
        dao.deleteSertifikati(i);

        model.addAttribute("success", "Proizvodjač " + a.getProizvodjac()
                + " " + a.getAdresa() + " je uspešno obrisan");
        return "dobroDosli";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/newuser.web"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        Sertifikati sertifikati = new Sertifikati();
        model.addAttribute("sertifikati", sertifikati);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     *
     * @param sertifikati
     * @param result
     * @return
     */
    @RequestMapping(value = {"/newuser.web"}, method = RequestMethod.POST)
    public String saveUser(@Valid Sertifikati sertifikati, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        Dao dao = new Dao();
        int noviId = dao.addSertifikati(sertifikati);
        sertifikati.setId(noviId);

        model.addAttribute("user", sertifikati);

        model.addAttribute("success", "Proizvođač " + sertifikati.getId() + " " + sertifikati.getProizvodjac()
                + " " + sertifikati.getAdresa() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/add-document-{userId}.web"}, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        Dao dao = new Dao();
        Sertifikati sertifikati = dao.getSertifikatiById(userId);
//		User user = userService.findById(userId);
        model.addAttribute("user", sertifikati);

        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);

        List<ProizvodjacDocument> documents = dao.findAllByProizvodjacId(userId);
        model.addAttribute("documents", documents);

        return "managedocuments";
    }

    @RequestMapping(value = {"/download-document-{userId}-{docId}.web"}, method = RequestMethod.GET)
    public String downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException {
        Dao dao = new Dao();
        ProizvodjacDocument document = dao.nadjiProizvodjacDocumentPoId(docId);
//		ProizvodjacDocument document = ProizvodjacDocument.findById(docId);
        response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getName() + "\"");

        FileCopyUtils.copy(document.getContent(), response.getOutputStream());

        return "redirect:/add-document-" + docId + ".web";
    }

    @RequestMapping(value = {"/delete-document-{userId}-{docId}"}, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int userId, @PathVariable int docId) {
        Dao dao = new Dao();
        dao.deleteProizvodjacDocument(docId);
//		userDocumentService.deleteById(docId);
        return "redirect:/add-document-" + userId + ".web";
    }

    /**
     * Upload single file using Spring Controller
     *
     * @param brojSertifikata
     * @param nazivVrstaProizvodnje
     */
    @RequestMapping(value = "/uploadFile.web", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@ModelAttribute("fileBucket") FileBucket fileBucket, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {

            ModelAndView mav = new ModelAndView();
            mav.setViewName("dobroDosli");
            mav.addObject("user", fileBucket);
            mav.addObject("success", "Podaci nisu pravilno uneti ....");
            return mav;
        }
        System.out.println(fileBucket.getBrojSertifikata());

        Dao dao = new Dao();

        ProizvodjacDocument pd = new ProizvodjacDocument();
        MultipartFile multipartFile = fileBucket.getFile();

        pd.setName(fileBucket.getName());
        pd.setDescription(fileBucket.getDescription());
        pd.setType(fileBucket.getType());
        // mora da uzme file samo ovako, ime i type
        pd.setName(multipartFile.getOriginalFilename());
        pd.setDescription(fileBucket.getDescription());
        pd.setType(multipartFile.getContentType());

        pd.setId(fileBucket.getId());
//                        pd.setUserId(fileBucket.get);userId = userId;

        try {

            pd.setContent(fileBucket.getFile().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SpringMVCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pd.setBrojSertifikata(fileBucket.getBrojSertifikata());
        pd.setProizvodjacId(fileBucket.getProizvodjacId());
        pd.setNazivVrstaProizvodnje(fileBucket.getNazivVrstaProizvodnje());

        pd.setDatumKontrole(fileBucket.getDatumKontrole());
        pd.setDatumIzdavanja(fileBucket.getDatumIzdavanja());
        pd.setVaziDo(fileBucket.getVaziDo());
        pd.setTipSertifikata(fileBucket.getTipSertifikata());
        pd.setRezerva1(fileBucket.getRezerva1());
        String uredu = dao.addDocument(pd);

        Sertifikati sertifikati = dao.getSertifikatiById(fileBucket.getProizvodjacId());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("registrationsuccess");
        mav.addObject("user", sertifikati);
        mav.addObject("success", uredu);

        return mav;
    }

    @RequestMapping(value = {"/add-document-{userId}.web"}, method = RequestMethod.POST)
    public String uploadDocument(
            @PathVariable int userId, @PathVariable MultipartFile file, @PathVariable String description,
            BindingResult result, ModelMap model)
            throws IOException {

        System.out.println("Fetching file");

        Dao dao = new Dao();
        Sertifikati sertifikati = dao.getSertifikatiById(userId);
        model.addAttribute("user", sertifikati);
        return "redirect:/add-document-" + userId;

    }

    private void saveDocument(FileBucket fileBucket, Sertifikati user) throws IOException {

        ProizvodjacDocument document = new ProizvodjacDocument();

        MultipartFile multipartFile = fileBucket.getFile();

        document.setName(multipartFile.getOriginalFilename());
        document.setDescription(fileBucket.getDescription());
        document.setType(multipartFile.getContentType());
        document.setContent(multipartFile.getBytes());

        Dao dao = new Dao();
        dao.addDocument(document);

    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String output
                = ServletRequestUtils.getStringParameter(request, "output");

        //dummy data
        Map<String, String> revenueData = new HashMap<String, String>();
        revenueData.put("1/20/2010", "$100,000");
        revenueData.put("1/21/2010", "$200,000");
        revenueData.put("1/22/2010", "$300,000");
        revenueData.put("1/23/2010", "$400,000");
        revenueData.put("1/24/2010", "$500,000");

        if (output == null || "".equals(output)) {
            //return normal view
            return new ModelAndView("RevenueSummary", "revenueData", revenueData);

        } else if ("PDF".equals(output.toUpperCase())) {
            //return excel view
            return new ModelAndView("PdfRevenueSummary", "revenueData", revenueData);

        } else {
            //return normal view
            return new ModelAndView("RevenueSummary", "revenueData", revenueData);

        }
    }

    @RequestMapping(value = "/reportPdf.web", method
            = RequestMethod.GET)
    public String reportPdf(HttpServletRequest request, HttpServletResponse response) {
        return "reportPdf";
    }

}
