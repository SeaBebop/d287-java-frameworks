package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        outsourcedPartRepository.deleteAll();
        inhousePartRepository.deleteAll();

        if( outsourcedPartRepository.count() == 0 && inhousePartRepository.count() == 0){
            InhousePart bike_body = new InhousePart();
            bike_body.setName("Bike Body");
            bike_body.setInvMin(6);
            bike_body.setInvMax(300);
            bike_body.setInv(200);
            bike_body.setPrice(10.0);
            bike_body.setId(1L);
            inhousePartRepository.save(bike_body);

            InhousePart wheels = new InhousePart();
            wheels.setName("Wheels");
            wheels.setInv(200);
            wheels.setInvMin(6);
            wheels.setInvMax(300);
            wheels.setPrice(10.0);
            wheels.setId(10L);
            inhousePartRepository.save(wheels);

            InhousePart chains = new InhousePart();
            chains.setName("Chains");
            chains.setInv(100);
            chains.setInvMin(5);
            chains.setInvMax(200);
            chains.setPrice(15.0);
            chains.setId(11L);
            inhousePartRepository.save(chains);

            InhousePart seats = new InhousePart();
            seats.setName("Seats");
            seats.setInv(100);
            seats.setInvMin(5);
            seats.setInvMax(200);
            seats.setPrice(20.0);
            seats.setId(12L);
            inhousePartRepository.save(seats);

            OutsourcedPart paint = new OutsourcedPart();
            paint.setName("Paint");
            paint.setInvMin(1);
            paint.setInvMax(100);
            paint.setInv(50);
            paint.setPrice(30.0);
            paint.setId(13L);
            outsourcedPartRepository.save(paint);

            OutsourcedPart merchandise_paint = new OutsourcedPart();
            merchandise_paint.setName("Merchandise Paint");
            merchandise_paint.setInvMin(1);
            merchandise_paint.setInvMax(50);
            merchandise_paint.setInv(30);
            merchandise_paint.setPrice(60.0);
            merchandise_paint.setId(14L);
            outsourcedPartRepository.save(merchandise_paint);

            OutsourcedPart merchandise_stickers = new OutsourcedPart();
            merchandise_stickers.setName("Merchandise Stickers");
            merchandise_stickers.setInvMin(1);
            merchandise_stickers.setInvMax(50);
            merchandise_stickers.setInv(30);
            merchandise_stickers.setPrice(40.0);
            merchandise_stickers.setId(15L);
            outsourcedPartRepository.save(merchandise_stickers);

            OutsourcedPart custom_rims = new OutsourcedPart();
            custom_rims.setName("Custom Rims");
            custom_rims.setInvMin(1);
            custom_rims.setInvMax(50);
            custom_rims.setInv(30);
            custom_rims.setPrice(50.0);
            custom_rims.setId(16L);
            outsourcedPartRepository.save(custom_rims);

            OutsourcedPart merchandise_airpumps = new OutsourcedPart();
            merchandise_airpumps.setName("Merchandise Airpumps");
            merchandise_airpumps.setInvMin(1);
            merchandise_airpumps.setInvMax(50);
            merchandise_airpumps.setInv(30);
            merchandise_airpumps.setPrice(55.0);
            merchandise_airpumps.setId(17L);
            outsourcedPartRepository.save(merchandise_airpumps);
        }
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        productRepository.deleteAll();
        if( productRepository.count() == 0 ) {
            Product bicycle = new Product("bicycle", 100.0, 5);
            Product unicycle = new Product("unicycle", 100.0, 11);
            Product mountain_bicycle = new Product("mountain_bicycle", 200.0, 13);
            Product disney_unicycle = new Product("disney_unicycle", 5000.0, 2);
            Product marathon_bicycle = new Product("marathon_bicycle", 300.0, 11);

            productRepository.save(bicycle);
            productRepository.save(unicycle);
            productRepository.save(mountain_bicycle);
            productRepository.save(disney_unicycle);
            productRepository.save(marathon_bicycle);
        }




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
