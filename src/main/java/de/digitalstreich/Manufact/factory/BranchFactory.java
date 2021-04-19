package de.digitalstreich.Manufact.factory;

import com.github.javafaker.Faker;
import de.digitalstreich.Manufact.db.BranchRepository;
import de.digitalstreich.Manufact.db.CategoryRepository;
import de.digitalstreich.Manufact.model.Branch;
import de.digitalstreich.Manufact.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Locale;

@Service
public class BranchFactory {

    @Autowired
    private BranchRepository branchRepository;

    String[] branches = {
            "Agrarwirtschaft", "Bau", "Chemie & Rohstoffe",
            "Dienstleistungen & Handwerk", "E-Commerce", "Energie & Umwelt",
            "Finanzen, Versicherungen & Immobilien", "Freizeit", "Gesellschaft",
            "Handel", "Internet", "Konsum  FMCG", "Leben", "Medien",
            "Metall & Elektronik", "Pharma & Gesundheit", "Sport & Fitness",
            "Technik & Telekommunikation", "Tourismus & Gastronomie", "Verkehr & Logistik",
            "Werbung & Marketing"
    };

    public void createBranches() {
        Arrays.stream(branches)
                .map(Branch::new)
                .forEach(branchRepository::save);
    }

}
