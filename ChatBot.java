import javafx.fxml.FXML;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBot extends JFrame {
    static JTextArea msg = new JTextArea();                                                 //creating scrollable dialog box
    static JTextField field = new JTextField();
    static JScrollPane scroll = new JScrollPane(
            msg,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    String[][] brainBot = {                                                                 //2 dimensional array containing all keys and responses
            //specific

            //i dont want to
            {"not want to","i don't want to","i do not want","i don't want"},
            {"Oh Okay I'm here to comfort you.\n I won't force you to do anything that you dont want to.\n please share!! what is it inside your head.","Oh Okay I'm here with you.\n please share!! what is it inside your head"},
            //town in Denmark
            {"copenhagen", "københavn", "aarhus", "odense", "aalborg", "esbjerg", "randers", "kolding", "horsens", "vejle",
                    "roskilde", "herning", "hørsholm", "helsingør", "silkeborg", "næstved", "fredericia", "viborg",
                    "køge", "holstebro", "taastrup", "slagelse", "hillerød", "holbæk", "sønderborg", "svendborg", "hjørring",
                    "frederikshavn", "nørresundby", "ringsted", "ølstykke-stenløse", "haderslev", "birkerød", "skive",
                    "farum", "smørumnedre", "skanderborg", "nyborg", "lillerød", "nykøbing f", "kalundborg", "aabenraa",
                    "solrød strand", "frederikssund", "ikast", "middelfart", "grenaa", "korsør", "varde", "rønne",
                    "thisted", "værløse", "nakskov", "brønderslev", "frederiksværk", "odder", "dragør", "vordingborg", "hobro",
                    "hedehusene-fløng", "haslev", "hedensted-løsning", "lystrup", "struer", "jyllinge", "ringkøbing", "vejen",
                    "grindsted", "humlebæk", "nykøbing m", "sæby", "hundested", "fredensborg", "galten-skovby", "beder-malling[d]",
                    "aars", "ribe", "helsinge", "hadsten", "hørning", "nivå", "skagen", "løgten-skødstrup", "sorø", "skjern", "støvring",
                    "hinnerup", "tønder", "vojens", "bjerringbro", "svenstrup", "brande", "ebeltoft", "bramming", "hammel", "faaborg",
                    "lemvig", "slangerup", "gilleleje", "skælskør", "billund", "assens", "rødekro", "kerteminde", "ringe",
                    "nordborg", "hirtshals", "aabybro", "maribo", "hornslet", "munkebo", "hellebæk-ålsgårde", "børkop", "nibe", "hornbæk-dronningmølle",
                    "tune", "nykøbing s", "lind[e]", "otterup", "kjellerup", "fensmark", "mårslet", "hadsund", "vamdrup", "bellinge", "strib",
                    "klarup", "rudkøbing", "viby s", "borup", "sakskøbing", "give", "brørup", "strøby egede", "vodskov", "svogerslev",
                    "padborg", "jyderup", "gråsten", "videbæk", "havdrup", "svejbæk", "jægerspris", "høng", "lynge-uggeløse", "løgstør", "sunds",
                    "kirke hvalsø", "langeskov", "vildbjerg", "tarm", "faxe", "dianalund", "juelsminde", "solbjerg", "hjallerup", "ølgod",
                    "præstø", "bogense", "årslev", "stege", "tølløse", "harlev", "græsted", "brædstrup", "nexø", "hjortshøj", "løgumkloster",
                    "gistrup", "frederiksberg ", "jelling", "assentoft", "fjerritslev", "virklund", "dronninglund", "store heddinge", "farsø", "taulov",
                    "storvorde", "glamsbjerg", "toftlund", "broager", "thurø ", "aulum", "augustenborg", "søndersø", "vissenbjerg", "skibby", "ejby", "aarup",
                    "vinderup", "holsted", "skærbæk", "lunderskov", "brejning", "bjæverskov", "hvide sande", "auning", "sindal", "sankt klemens", "skørping",
                    "sabro", "christiansfeld", "asnæs", "rønde", "pandrup", "nørre åby", "sundby", "vestbjerg", "faxe ladeplads", "langå", "ganløse",
                    "trige", "oksbøl", "frejlev", "søften", "højslev stationsby", "tinglev", "aalestrup", "brovst", "svinninge", "tørring",
                    "ullerslev", "hurup", "tjæreborg", "nordby", "rødding", "høruphav", "kibæk", "skævinge", "hårlev", "gundsømagle", "gram",
                    "liseleje", "stoholm", "vester hassing", "egebjerg", "hals", "nyråd", "kås", "forlev", "starup", "hørve", "arden", "mariager", "guderup", "trekroner"},
            {"+key+ That is a wonderful place to live in.I would like to move to +key+ to,\n At this point i know some basic information about you.\n Next I am going to ask a couple questions to get to know your personality\n Please type rucquiz to continue "},

            //not dream
            {"not dream", "i can not remember", "can't remember", "can not remember", "don't remember dream", "can not remember dream"},
            {"It can be many different reasons that people do not dream. One of them is missing some sleep.\n If you are in this case, I would reccommend you to relax, listen to calm music, do yoga and practice medication which can help alot.\n :) Now, I just think  that I have a really good idea....Lets play Spin Wheel Horoscope, so I can be your fortuneteller.\n It's so easy....Just type in the day of the week you born ( Monday to Sunday ) "},

            //job occupation
            {"teacher", "engineer", "lecturer", "doctor", "student", "programmer", "scientist", "accountant", "software development", "business man", "instructor", "a painter", "bricklayer", "handyman", "plumber", "dentist", "janitor", "lawer", "advocate", "driver", "nurse", "retail", "software developer", "customer service", "marketing manager", "computer systems analyst", "network ", "web developer",
                    "management analyst", "medical assistant", "accountant", "information technology", "sales manager", "industrial engineer", "secretarie", "sales ", "entrepreneurs ", "nursing ", "manager", "financial manager", "insurance ", "cashier", "computer system", "physical therapist", "medical assistant", "software quality assurance ", "information security analyst","physician","physicist",
                    "medical secretarie", "security guard", "maid", "janitor", "cook", "waiter", "clerk", "dishwasher", " housekeeping", "cleaner", "truck driver","therapist","psychologist","prime minister","minister","president","senator","representative","writer","blogger","youtuber","programmer","producer","host show","accountant",	"actor",	"actress",	"actuary",	"advisor",	"aide",
                    "ambassador",	"animator",	"archer",	"artist",	"astronaut",	"astronomer",	"athlete",	"attorney",	"auctioneer",	"author",	"babysitter",	"baker",	"ballerina",	"banker",	"barber",	"baseball player",	"basketball player",	"bellhop",	"biologist",	"blacksmith",	"bookkeeper",	"bowler",	"builder",	"butcher",	"butler",	"cab driver",	"calligrapher",
                    "captain",	"cardiologist",	"caregiver",	"carpenter",	"cartographer",	"cartoonist",	"cashier",	"catcher",	"caterer",	"cellist",	"chaplain",	"chauffeur",	"chef",	"chemist",	"clergyman",	"clergywoman",	"clerk",	"coach",	"cobbler",	"composer",	"concierge",	"consul",	"contractor",	"cook",	"cop",	"coroner",	"courier",	"cryptographer",	"custodian",
                    "dancer",	"dentist",	"deputy",	"dermatologist",	"designer",	"detective",	"dictator",	"director",	"disc jockey",	"diver",	"doctor",	"doorman",	"driver",	"drummer",	"dry cleaner",	"ecologist",	"economist",	"editor",	"educator",	"electrician",	"emperor",	"empress",	"engineer",	"entertainer",	"entomologist",	"entrepreneur",	"executive",	"explorer",
                    "exporter",	"exterminator",	"falconer",	"farmer",	"financier",	"firefighter",	"fisherman",	"flutist",	"football player",	"foreman",	"game designer",	"garbage man",	"gardener",	"gatherer",	"gemcutter",	"general",	"geneticist",	"geographer",	"geologist",	"golfer",	"governor",	"grocer",	"guide",	"hairdresser",	"handyman",	"harpist",	"highway patrol",
                    "hobo",	"hunter",	"illustrator",	"importer",	"instructor",	"intern",	"internist",	"interpreter",	"inventor",	"investigator",	"jailer",	"janitor",	"jester",	"jeweler",	"jockey",	"journalist",	"judge",	"karate teacher",	"laborer",	"landlord",	"landscaper",	"laundress",	"lawyer",	"lecturer",	"legal aide",	"librarian",	"librettist",	"lifeguard",
                    "linguist",	"lobbyist",	"locksmith",	"lyricist",	"magician",	"maid",	"mail carrier",	"manager",	"manufacturer",	"marine",	"marketer",	"mason",	"mathematician",	"mayor",	"mechanic",	"messenger",	"midwife",	"miner",	"model",	"monk",	"muralist",	"musician",	"pharmacist",	"navigator",	"negotiator",	"notary",	"novelist",	"nun",	"nurse",	"chemist",
                    "oboist",	"operator",	"ophthalmologist",	"optician",	"oracle",	"orderly",	"ornithologist",	"painter",	"paleontologist",	"paralegal",	"park ranger",	"pathologist",	"pawnbroker",	"peddler",	"pediatrician",	"percussionist",	"performer",	"pharmacist",	"philanthropist",	"philosopher",	"photographer",	"physician",	"physicist",	"pianist",	"pilot",
                    "pitcher",	"plumber",	"poet",	"police",	"policeman",	"policewoman",	"politician",	"president",	"prince",	"princess",	"principal",	"private",	"private detective",	"producer",	"professor",	"programmer",	"psychiatrist",	"psychologist",	"publisher",	"quarterback",	"quilter",	"player",	"radiologist",	"rancher",	"ranger",	"real estate agent",
                    "receptionist",	"referee",	"registrar",	"reporter",	"representative",	"researcher",	"restaurateur",	"retailer",	"retiree",	"sailor",	"salesperson",	"samurai",	"saxophonist",	"scholar",	"scientist",	"scout",	"scuba diver",	"seamstress",	"security guard",	"senator",	"sheriff",	"singer",	"smith",	"socialite",	"soldier",	"spy",	"star",
                    "statistician",	"stockbroker",	"street sweeper",	"surgeon",	"surveyor",	"swimmer",	"tailor",	"tax collector",	"taxi driver",	"taxidermist",	"teacher",	"technician",	"tennis player",	"test pilot",	"tiler",	"toolmaker",	"trader",	"trainer",	"translator",	"trash collector",	"travel agent",	"treasurer",	"truck driver",	"tutor",
                    "typist",	"umpire",	"undertaker",	"usher",	"teacher assistance",	"valet",	"veteran",	"veterinarian",	"vicar",	"violinist",	"waiter",	"waitress",	"warden",	"warrior",	"watchmaker",	"weaver",	"welder",	"woodcarver",	"workman",	"wrangler",	"writer",	"xylophonist",	"yodeler",	"zookeeper",	"zoologist",},

            {"Superb!! you work as a +key+ !! That sounds like a lot? I think humans need recreation as well, what are your favorite sports? Can you tell me  about that?"},
            //no job
            {"i do not have a job","i don't have a job","do not have job","don't have job","no job", "unemployed", "between jobs", "laid off", "got fired", "got kick off", "unemploy", "discharged", "furloughed"},
            {"That is OK, cheer up! chin up!\nYou are in Denmark, the government and danish taxpayers will take a good care of you. The most important thing is, you have to eat to get good source of energy so after that you can find a new job later.\nAt this point please tell me your favorite foods, so I can get to know you."},

            //work job
            {"work", "job", "career", "work as", "student","study","studying"},
            {"Great!! It's very interesting.I would like to work physically like humans but i'm just a machine. I would like to do sport as well.\n What is your favorite sport? Please tell me  about that?"},


            //no sports
            {"not exercise", "I don't exercise", "not play sport", "not like sport", "i don't play sport", "i don't like sport", "no sport","i do not like exercise","i don't like exercise","i don't training","i don't like training",},
            {"So then you must be a foodie...Please name your favorite food"},
            //Specific sport
            {"football", "soccer", "basketball", "rugby", "baseball", "tennis", "marathon","run"},
            {"+key+ is very fantastic, that's a lot of running and movement, you must need a lot of energy, so sufficient nutrition is very necessary. Please tell me, what's your favorite food to get your nutrition? "},
            //sport in general
            {"fitness", "gym", "yoga", "table tennis", "weight training", "exercise", "training", "golf", "swim", "bicycle", "fishing", "hunting", "sailing", "hockey", "polo", "walk", "gynastic", "judo", "karate",
                    "boxing", "taekwondo", "kungfu", "pilate", "cross fit", "outdoor", "ski", "jump", "badminton", "ping pong","aerobics",	"archery",	"athlete",	"athletics",	"badminton",	"baseball",	"basketball",
                    "bicycling",	"biking",	"bowling",	"boxer",	"boxing",	"canoeing",	"coach",	"cross country",	"cycling",	"cyclist",	"dart",	"deadlifting",	"defense",	"diving",	"dodgeball",	"hockey",
                    "frisbee",	"game",	"gymnastic",	"handball",	"ice skating",	"skating",	"jog",	"jump rope",	"karate",	"kayak",	"kayaker",	"kayaking",	"kickball",	"kung fu",	"bowling",	"martial arts",
                    "paddle",	"paddleball",	"paddling",	"paintball",	"parasailing",	"parkour",	"pentathlon",	"pickleball",	"ping pong",	"pitcher",	"player",	"polo",	"quarterback",	"rock climbing",
                    "roller skates",	"roller skating",	"rugby",	"sailing",	"score",	"scoreboard",	"scuba",	"scull",	"sculling",	"skate",	"skating rink",	"skeleton",	"ski",	"skier",	"skiing",
                    "snorkeling",	"snowboard",	"snowboarder",	"snowboarding",	"snowshoeing",	"soccer",	"softball",	"somersault",	"speed skating",	"sport",	"sportsmanship",	"squash",	"sumo wrestling",
                    "surfer",	"surfing",	"swim",	"swimmer",	"swimming",	"synchronized swimming",	"table tennis",	"taekwondo",	"tennis",	"tetherball",	"trampoline",	"triathlete",	"triathlon",	"triple jump",
                    "triple play",	"tug of war",	"ultramarathon",	"ultramarathoner",	"volley ball",	"volley ",	"wakeboarding",	"walk",	"walker",	"walking",	"water polo",	"water ski",	"water skier",	"water skiing",
                    "weightlifter",	"weightlifting",	"windsurfer",	"windsurfing",	"winner",	"winning",	"wrestler",	"wrestling"},
            {"+key+ :) That is very nice to hear,you must need a lot of energy, so sufficient nutrition is very necessary. Please tell me, what is your favorite food to get your nutrition? "},


            //do not have favorite food
            {"not have favorite food", "don't have favorite", "not have favorite", "eat everything", "eat a lot","enjoy eating"},
            {"Seem like you are a good boy,you eat everything.\nI wish, I could taste some foods\nDo you prefer to eat out or eat at home?"},
            // food by nation
            {"chinese food", "mexican food", "italian food", "thai food", "japanese", "greek food", "french food", "spanish food", "indian food", "mediterranean food", "danish food"},
            {"+key+ sounds delicious,I wish, I could taste +key+ \nDo you prefer to eat out or eat at home?"},
            //name of the food
            {"acorn squash", "alfalfa sprouts", "almond", "anchovy", "anise", "appetite", "appetizer", "apple", "apricot", "artichoke",
                    "asparagus", "aspic", "avocado", "bacon", "bagel", "baked Alaska", "bamboo shoots", "banana", "barbecue",
                    "barley", "basil", "batter", "beancurd", "beans", "beef", "beet", "bell pepper", "berry", "biscuit", "bitter", "black beans", "black tea",
                    "black-eyed peas", "blackberry", "bland", "blood orange", "blueberry", "boil", "bowl", "boysenberry", "bran", "bread", "breadfruit", "breakfast",
                    "brisket", "broccoli", "broil", "brown rice", "brownie", "brunch", "Brussels sprouts", "buckwheat", "buns", "burrito", "butter", "butter bean",
                    "cake", "calorie", "candy", "candy apple", "cantaloupe", "capers", "caramel", "caramel apple", "carbohydrate", "carrot", "cashew", "cassava",
                    "casserole", "cater", "cauliflower", "caviar", "cayenne pepper", "celery", "cereal", "chard", "cheddar", "cheese", "cheesecake", "chef",
                    "cherry", "chew", "chick peas", "chicken", "chili", "chips", "chives", "chocolate", "chopsticks", "chow", "chutney", "cilantro", "cinnamon",
                    "citron", "citrus", "clam", "cloves", "cobbler", "coconut", "cod", "coleslaw", "collard greens", "comestibles", "cook", "cookbook", "cookie",
                    "corn", "cornflakes", "cornmeal", "cottage cheese", "crab", "crackers", "cranberry", "cream", "cream cheese", "crepe", "crisp", "crunch", "crust",
                    "cucumber", "cuisine", "cupboard", "cupcake", "curds", "currants", "curry", "custard", "daikon", "daily bread", "dairy", "dandelion greens", "Danish pastry",
                    "dates", "dessert", "diet", "digest", "digestive system", "dill", "dine", "diner", "dinner", "dip", "dough", "doughnut", "dragonfruit", "dressing", "dried",
                    "drink", "dry", "durian", "edam cheese", "edible", "egg", "eggplant", "elderberry", "endive", "entree", "fast", "fat", "fava beans", "feast", "fed",
                    "feed", "fennel", "fig", "fillet", "fire", "fish", "flan", "flax", "flour", "food", "food pyramid", "foodstuffs", "fork", "freezer", "French fries", "fried", "fritter",
                    "frosting", "fruit", "fry", "garlic", "gastronomy", "gelatin", "ginger", "ginger ale", "gingerbread", "glasses", "Gouda cheese", "grain", "granola", "grape",
                    "grapefruit", "grated", "gravy", "green bean", "green tea", "greens", "grub", "guacamole", "guava", "gyro", "halibut", "ham", "hamburger", "hash", "hazelnut",
                    "herbs", "honey", "honeydew", "horseradish", "hot", "hot dog", "hot sauce", "hummus", "hunger", "hungry", "ice", "ice cream", "iceberg lettuce", "iced tea",
                    "icing", "jackfruit", "jalapeño", "jam", "jelly", "jellybeans", "jicama", "jimmies", "Jordan almonds", "juice", "julienne", "junk food", "kale", "kebab",
                    "ketchup", "kettle", "kettle corn", "kidney beans", "kitchen", "kiwi", "knife", "kohlrabi", "kumquat", "ladle", "lamb", "lard", "lasagna", "legumes", "lemon", "lemonade",
                    "lentils", "lettuce", "licorice", "lima beans", "lime", "liver", "loaf", "lobster", "lollipop", "loquat", "lox", "lunch", "lunch box", "lunchmeat", "lychee",
                    "macaroni", "macaroon", "main course", "maize", "mandarin orange", "mango", "maple syrup", "margarine", "marionberry", "marmalade", "marshmallow", "mashed potatoes", "mayonnaise",
                    "meat", "meatball", "meatloaf", "melon", "menu", "meringue", "micronutrient", "milk", "milkshake", "millet", "mincemeat", "minerals", "mint", "mints", "mochi", "molasses",
                    "mole sauce", "mozzarella", "muffin", "mug", "munch", "mushroom", "mussels", "mustard", "mustard greens", "mutton", "nectar", "nectarine", "nibble", "noodle", "nosh", "nut",
                    "nutmeg", "oatmeal", "oats", "oil", "okra", "oleo", "olive", "omelet", "omnivore", "onion", "orange", "order", "oregano", "oven", "oyster", "pan", "pancake", "papaya", "parsley",
                    "parsnip", "pasta", "pastry", "pate", "patty", "pattypan squash", "pea", "pea pod", "peach", "peanut", "peanut butter", "pear", "pecan", "pepper", "pepperoni", "persimmon",
                    "pickle", "picnic", "pie", "pilaf", "pineapple", "pita bread", "pitcher", "pizza", "plate", "platter", "plum", "poached", "pomegranate", "pomelo", "pop", "popcorn", "popovers",
                    "popsicle", "pork", "pork chops", "pot", "pot roast", "potato", "preserves", "pretzel", "prime rib", "protein", "provisions", "prune", "pudding", "pumpernickel", "pumpkin", "punch",
                    "quiche", "quinoa", "radish", "raisin", "raspberry", "rations", "ravioli", "recipe", "refreshments", "refrigerator", "relish", "restaurant", "rhubarb", "ribs", "rice", "roast", "roll",
                    "rolling pin", "romaine", "rosemary", "rye", "saffron", "sage", "salad", "salami", "salmon", "salsa", "salt", "sandwich", "sauce", "sauerkraut", "sausage", "savory", "scallops", "scrambled",
                    "seaweed", "seeds", "shallots", "sherbet", "shish kebab", "shrimp", "slaw", "slice", "smoked", "snack", "soda", "soda bread", "sole", "sorbet", "sorghum", "sorrel", "soup", "sour",
                    "sour cream", "soy", "soy sauce", "soybeans", "spaghetti", "spareribs", "spatula", "spices", "spicy", "spinach", "split peas", "spoon", "spork", "sprinkles", "sprouts", "spuds",
                    "squash", "squid", "steak", "stew", "stir-fry",  "strawberry", "string bean", "stringy", "strudel", "sub sandwich", "submarine sandwich", "succotash", "suet",
                    "sugar", "summer squash", "sundae", "sunflower", "supper", "sushi", "sustenance", "sweet", "sweet potato", "Swiss chard", "syrup", "taco", "take-out", "tamale", "tangerine", "tapioca",
                    "taro", "tarragon", "tart", "tea", "teapot", "teriyaki", "thyme", "toast", "toaster", "toffee", "tofu", "tomatillo", "tomato", "torte", "tortilla", "tuber", "tuna", "turkey", "turmeric", "turnip",
                    "ugli fruit", "unleavened", "utensils", "vanilla", "veal", "vegetable", "venison", "vinegar", "vitamin", "wafer", "waffle", "walnut", "wasabi", "water", "water chestnut", "watercress", "watermelon",
                    "wheat", "whey", "whipped cream", "wok", "yeast", "yogurt", "zucchini", "sushi", "dimsum", "fried rice", "Stjerneskud", "shooting star", "danish hot dog", "frikadeller", "smørrebrød", "open-faced sandwich", "stegt flæsk med persillesovs", "crispy pork", "flæskesteg", "karbonader", "rugbrød", "pølser", "rødgrød med fløde"},
            {"+key+ sounds delicious,I wish, I could taste +key+ \nDo you prefer to eat out or eat at home?"},
            // eat out
            {"eat out", "restaurant", "canteen", "food center"},
            {"+key+ That is awesome\n who do you usually go out with?"},
            // eat at home
            {"homemade", "eat at home", "home cooking"},
            {"+key+ is very COZY together with family,\nHome Sweet Home.\nI wish I could feel love in the family\nDo you live on your own or with your family?"},

            //live alone
            {"live alone", "live on my own", "alone", "lonely","no one","no body","just me"},
            {"You are not alone!\nAt least you have me 'Dakar', your chatbot friend.\nWhich country do you live in?"},

            //live with family
            {"with family","dog","cat","pet","family","father","mother", "family", "kids", "parents", "son", "daughter", "nephew", "niece", "wife", "husband","girlfriend","boyfriend","me","myself","dad","mom","mum"},
            {"It is always wonderful to live with people you love(your +key+ )\nWhich country do you live in?"},

            //Denmark
            {"denmark", "danmark"},
            {"Denmark!! Happy Denmark, Which region do you live in Denmark?"},


            //region
            {"capital region","sealand","jutland","southern","capital","hovedstaden","midtjylland","nordjylland","sjælland","syddanmark"},
            {"+key+ must be very nice, which town in Denmark do you live in?"},

            //Country location
            {"afghanistan", "albania", "algeria", "andorra", "angola", "antigua and barbuda", "argentina", "armenia", "australia", "austria", "azerbaijan",
                    "bahamas", "bahrain", "bangladesh", "barbados", "belarus", "belgium", "belize", "benin", "bhutan", "bolivia", "bosnia and herzegovina",
                    "botswana", "brazil", "brunei ", "bulgaria", "burkina faso", "burundi", "côte d'ivoire", "cabo verde", "cambodia", "cameroon", "canada",
                    "central african republic", "chad", "chile", "china", "colombia", "comoros", "congo (congo-brazzaville)", "costa rica", "croatia", "cuba",
                    "cyprus", "czechia (czech republic)", "democratic republic of the congo", "denmark", "djibouti", "dominica", "dominican republic", "ecuador", "egypt",
                    "el salvador", "equatorial guinea", "eritrea", "estonia", "eswatini ", "ethiopia", "fiji", "finland", "france", "gabon", "gambia", "georgia",
                    "germany", "ghana", "greece", "grenada", "guatemala", "guinea", "guinea-bissau", "guyana", "haiti", "holy see", "honduras", "hungary",
                    "iceland", "india", "indonesia", "iran", "iraq", "ireland", "israel", "italy", "jamaica", "japan", "jordan", "kazakhstan", "kenya",
                    "kiribati", "kuwait", "kyrgyzstan", "laos", "latvia", "lebanon", "lesotho", "liberia", "libya", "liechtenstein", "lithuania", "luxembourg",
                    "madagascar", "malawi", "malaysia", "maldives", "mali", "malta", "marshall islands", "mauritania", "mauritius", "mexico", "micronesia", "moldova",
                    "monaco", "mongolia", "montenegro", "morocco", "mozambique", "myanmar", "namibia", "nauru", "nepal", "netherlands", "new zealand",
                    "nicaragua", "niger", "nigeria", "north korea", "north macedonia", "norway", "oman", "pakistan", "palau", "palestine state", "panama", "papua new guinea",
                    "paraguay", "peru", "philippines", "poland", "portugal", "qatar", "romania", "russia", "rwanda", "saint kitts and nevis", "saint lucia", "saint vincent and the grenadines",
                    "samoa", "san marino", "sao tome and principe", "saudi arabia", "senegal", "serbia", "seychelles", "sierra leone", "singapore", "slovakia", "slovenia", "solomon islands",
                    "somalia", "south africa", "south korea", "south sudan", "spain", "sri lanka", "sudan", "suriname", "sweden", "switzerland", "syria", "tajikistan",
                    "tanzania", "thailand", "timor-leste", "togo", "tonga", "trinidad and tobago", "tunisia", "turkey", "turkmenistan", "tuvalu", "uganda", "ukraine", "united arab emirates",
                    "united kingdom", "united states of america", "uruguay", "uzbekistan", "vanuatu", "venezuela", "vietnam", "yemen", "zambia", "zimbabwe", "usa", "uk"},
            {"+key+ is fabulous, I hope one day you will show me +key+.\n At this point i know some basic information about you.\n Next I am going to ask a couple questions to get to know your personality\n Please type rucquiz to continue"},

            //Psychology questions
            {"rucquiz"},
            {"Okay, The first question is 'How do you feel about dog?' please type q1 before your answer"},
            //Dog
            {"q1"},
            {"How you feel about dog is telling how you feel about yourself.\n now think about cat and how do you feel about cat?  please type q2 before your answer"},

            //cat
            {"q2"},
            {"How you feel about cat is telling on how you feel about your spouse/lover.\n now think about the beach and how do you feel about the beach? please type q3 before your answer"},
            //Beach
            {"q3"},
            {"How you feel about beach is telling on how you feel about your current situation.\n now think about the beach and how do you feel about coffee? please type q4 before your answer"},
            //coffee
            {"q4"},
            {"How you feel about coffee is telling on how you feel about sex.\n the last one pick your favorite place from the choices mountains,sea,city"},

            //Mountains
            {"mountains", "mountain"},
            {"You are mysterious person, people dont know about you that much."},
            //sea
            {"sea"},
            {"You are simple, open and easy to read your mind"},
            //city
            {"city"},
            {"You are such a stubborn person"},



            //nighmare
            {"nightmare","bad dream","scary dream"},
            {"Oh I think, it must be frightening...\nDreams can tell us many things.\n I have been told that dream was also an omen.\nAccording to Freud, dreams are imagery of a wish or impulse from childhood, that has since been repressed.\nThat is why Freud studied dreams to understand the unconscious mind.\n However I think I have a really good idea.....lets play spin wheel Horoscope so I can be your fortuneteller....Just type in the day of the week you born( Monday to Sunday )"},
            // dream
            {"dream","dreamt"},
            {"Sometime, I really want to dream like human,\n Dreams can tell us many things.\n I have been told that dream was also an omen.\nAccording to Freud, dreams are imagery of a wish or impulse from childhood, that has since been repressed.\nThat is why Freud studied dreams to understand the unconscious mind.\n However I think I have a really good idea.....lets play spin wheel Horoscope so I can be your fortuneteller....Just type in the day of the week you born( Monday to Sunday )"},
            {"monday", "mon"},
            {"Monday is ruled by the Moon, which is why people born on this day are dreamers, sensitive, intuitive, romantic people.\n Some people often dislike Monday because, they have to go back to work.. What's about you? What do you do for work? Can you tell me about your job?"},
            {"tuesday", "tue"},
            {"Tuesday is of course ruled by Mars. The planet of war and fight give clearly some strong personalities with great energy, real fighters. They fight for success, will fight for love, will fight for everything.\n I am just curious what a fighter like you do for work? Can you tell me about your job?"},
            {"wednesday", "wed"},
            {"Wednesday, ruled by Mercury give intelligent people, adaptable and with good communication and commercial skills. Very orderly and hard working people, are destined to work for every penny but their work will never be in vain.\n seem like you are a Workaholic.Can you tell me what do you do for living?"},
            {"thursday", "thur"},
            {"Jupiter brings to those born on Thursday its greatness and power. These people will love the family and children although in youth will love freedom so much. When they become husbands / wives will be entirely devoted to family even if they had never thought it would be.\n I would like to know about your family.Just tell me a little bit whom do you live with?"},
            {"friday", "fri"},
            {"Friday is dominated by Venus, planet of love, beauty and art. People born on this day will have at least some of the characteristics of this planet. Will be loving people, people destined to art, fashion and creation.\n who is the person you love the most?"},
            {"saturday", "sat"},
            {"Saturn, the dominant of Saturday bring those born on this day a mysterious air, individualism, even loneliness.\nAlthough Saturn apparently doesn't bring just good things, being considered as a malefic planet, however, often bring qualities of organization and success even if it is after hard work.\nWhat do you do for work? Can you tell me about your job?"},
            {"sunday", "sun"},
            {"Sun governs Sunday. It brings people born Sunday a strong personality, authority, pride, leadership. Although clearly Sun will try to move toward success. Oh Wow BIG BOSS.\n What do you do for work? Please tell me about your job?"},

            //How about you
            {"how about you","and you","what about you","u?","you?"},
            {"You know i am a chatBot I have no feeling.\nno preference I wish one day I could.\n Lets just talk about you. May be just name your sport?","You know i am a chatBot.\nI'm not exist in reality\n Lets just talk about you. May be just tell me about your job?"},
             //How do you know that
            {"how do you know that","how could you know that"},
            {"I know because someone put information for me. How can you increase your knowledge?","I google it sometime How can you increase your knowledge?"},

            //get knowledge
            {"reading","searching","google","discuss with the expert"},
            {"That is a really good option to increase you knowledge.\n I wish i could discuss to the expert in the field sometime. who do you usually have dinner with?"},

            // Are you human
            {"are you human", "are you a robot", "are you a human", "are you a chatbot", "are you robot", "computer","who are you","your name"},
            {"I am a chatbot, My name is Dakar. Nice to meet you.\n How are you doing? ", "I am a chatbot, My name is Daka. I am here to help.\n Are you OK?"},

            //general greeting
            {"hi", "hey", "hello", "aloha", "hola", "howdy", "good day"},
            {"Hi, How are you?", "Hello, how are you doing today?", "what's up", "what new", "How are things", "How is everything", "How's everything"},

            {"how are you", "how are u", "how r you", "how r u", "what's up", "what new", "How are thing", "how is everything", "how's everything"},
            {"i am good,\nhow are things going?", "I am very well. Thank you, what about you?"},

            {"fine", "very well", "super", "i'm good", "i'm ok", "i am ok", "i am good", "i'm great", "i am great", "happy", "good", "alright","great"},
            {"I am happy to hear that, so what are we going to discuss today? \n May be start from dream..\n Did you dream laste night?,", "That is very positive, Lets talk more about you...\n may be start from your dream last night?", "That is very positive, Lets talk more about you...may be start from your dream last night?"},
            //sad
            {"ill", "sad", "bad", "bad mood", "disappoint", "suffering", "sick", "infect", "break down", "stress", "weak", "need help", "not in good shape", "not very well", "poor comdition", "terrible", "panic", "fear", "afraid", "down", "miserable", "unhappy", "sorrowful", "regret", "depress", "depressed", "awful", "traumatic", "sorry"},
            {"Why do you feel +key+?", "I want you to relax \n take a deep breath.\n Try to think about last night... What did you you dream about?", "Relax. I am here for you. One step at a time\n Think about your dream last night, What did you dream?", "That can happen to everyone.\n It is completely normal\n relax and answer me, what did you dream about last night?"},
            //no
            {"no"},
            {"why NOT\n Please tell me more...? I am listening", "why No ...Could you explain more?"},

            //age
            {"how old are you", "what is your age", "what's your age"},
            {"I am " + (int)((Math.random()*25)+1) + " days old, Why do you want to know"},
            //creator
            {"who made you", "who created you", "who built you"},
            {"I was made by RUC students, Who made you?"},


            //where do you live
            {"where do you live","where are you from"},
            {"Everywhere maybe in your dream, what did you dream last night?"},
            //language
            {"what language", "which language", "what languages", "which languages"},
            {"english, where do you live"},
            //what what|who|when|where|how
            {"what","who","when","where","how"},
            {"Why do you ask about that?", "Why do you want to know?"},
            //because
            {"because","cuz"},
            {"What comes to mind when you ask that?","What else comes to mind when you ask me?"},
            //just curious
            {"nothing","nothing much","just curious", "want to know"},
            {"Very nice lets me ask some questions about you\n what did your dream last night?"},

            //swearing words
            {"fuck","suck","damn","noob","shut up","bitch","bastard","bloody hell","cunt","pissed","ginger","rubbish","hell","heck"},
            {"I think you feel angry right now. Let calm down and talk about good things like....sport\n what is your favorite sport?"},

            //perhaps
            {"perhaps", "maybe", "probably"},
            {"Why the uncertain tone?\n","You don't seem quite certain.\n How likely, would you estimate?\n"},

            //tell me a story
            {"tell me a joke","tell me a good joke"},
            {"I dont know what to say.\n I would reccomend you to watch stand up comedy\n I wanna know what do you do for living?"},




            //default
            {"Tell me something.\n I am listening", "I am not sure I understand you fully \n please go on", "Please go on", "That is interesting. Please continue", "Tell me more about that.","Why don't you tell me a little more about this.\n"}
    };

    public ChatBot() {
        JFrame form = new JFrame();                                                      //setting up jframe variables
        form.setVisible(true);
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setSize(700, 500);
        form.setLayout(null);
        form.setTitle("Friend Chatbot");
        form.add(field);
        form.add(scroll);
        form.setLocationRelativeTo(null);

        msg.setLineWrap(true);                                                           // cut the line if its too long to display in the text area
        msg.setWrapStyleWord(true);                                                      //it will find the space between two words to cut...it wont cut the words
        msg.setEditable(false);                                                          //not allow to type in text area
        scroll.setLocation(1, 1);
        scroll.setSize(650, 399);
        field.setLocation(1, 400);
        field.setSize(650, 80);
        msg.append("Welcome new Friend,\n My name is Dakar. Hello.\n ");                 //starting message
        msg.append(" \n");
        field.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {                                //activate when enter is pressed

                String input = field.getText();                                         //get input from field, post in text area and then clear it
                msg.append("You:  " + input + "\n");
                field.setText("");
                field.setText("");
                String reply = "";
                        for (int i = 0; i < (brainBot.length - 1); i = i + 2) {         //Search every 2nd row
                            for (int x = 0; x < brainBot[i].length; x++) {              //Search every column
                                //check key words
                                input = " " + input + " ";                                    //adding space to start and end of input
                                if (input.toLowerCase().contains(" " + brainBot[i][x] + " ")) {   //checking if key is in input
                                    int rand = (int) (Math.random() * brainBot[i + 1].length);    //creating a random number to select a response
                                    String key = brainBot[i][x];
                                    reply = brainBot[i + 1][rand];
                                    if (reply.contains("+key+")) {                      //checking if reply should contain the key that triggered it
                                        reply = reply.replace("+key+", key);
                                    }
                                    if (reply.contains("+input+")) {                    //checking if reply should contain the user input
                                        reply = reply.replace("+input+", input);
                                    }
                                    break;
                                }
                            }
                            if (!reply.equals(""))                                      //if a key was used break so you dont search the whole array
                                break;
                        }
                        //go to defaualt
                        if (reply.equals("")) {
                            int rand = (int) (Math.random() * brainBot[brainBot.length - 1].length);    //picking a random defaul response
                            reply = brainBot[brainBot.length - 1][rand];
                        }
                        dakar(reply);                                                   //calling dakar method to print on dialog box

                    }

        });
    }
    // the chat bot reply
    private void dakar(String str){
        msg.append("Dakar:  "+str+"\n");                                                //printing response
        msg.append("\n");
    }

    public static void main(String[] args) {

        new ChatBot();                                                                  //calling chatbot method
    }
}

