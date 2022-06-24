public class Reverse {
    public static int findNumValues( String text, String findText){
        int appearanceCount = 0; 

        //String.equalsIgnoreCase should do the job
        text = text.toLowerCase();
        findText = findText.toLowerCase();  
        String[] tempArr = text.split( findText ); 

        appearanceCount = tempArr.length - 1; 

        return appearanceCount; 
    }


    public static int findNumberOfQuotes( String text ){
        int quoteCount = 0;
        //char targetChar = '"'; //works when comparing to indi chars, not Strings.
        char targetChar = '\"'; // both work, but escape char would be required if comparing to String.
        for( int i = 0; i < text.length(); ++i ){
            if( text.charAt(i) == targetChar){
                quoteCount++; 
            }
        }
        //This halving since we don't care how many marks appeared but the quotes enclosed.
        return quoteCount /= 2; 
    }


    public static String replaceCharacter( String text, char charToReplace, char replacement){
        String alteredText = new String("");
        for( int i = 0; i < text.length(); ++i ){
            //this method writes to new memory
            //example uses string.substring() to access original memory and rewrite in place.
            //Remember that Strings are immutable; this means that their value cannot be changed. 
            //Every time we replace a character, we are creating a brand new String.
            if ( text.charAt(i) == charToReplace ){
                alteredText = alteredText + replacement;
                continue;  
            }
            alteredText = alteredText + text.charAt(i); 
        }

        return alteredText;
    }

    public static String reverseString( String text ){
        String plainText = "";
        for( int i = 0; i < text.length(); ++i ){

            plainText = text.charAt(i) + plainText; 
        }

        return plainText; 
    }
    public static void main( String[] args ){
        
        //String text = new String("\".<romr<v<N\" sa <man hcus htiW\n ,rood r<bmahc sih <voba tsub d<rutplucs <ht nopu tsa<b ro driB —rood r<bmahc sih <voba drib gni<<s htiw d<ss<lb saw t<y r<v< gni<b namuh gnivil on taht gni<<rga pl<h tonnac <w roF ;<rob ycnav<l<r <lttil—gnina<m <lttil r<wsna sti hguohT ,ylnialp os <sruocsid ra<h ot lwof ylniagnu siht d<ll<vram I hcuM\n\n\".<romr<v<N\" n<vaR <ht htouQ\n \"!<rohs nainotulP s’thgiN <ht no si <man yldrol yht tahw <m ll<T —<rohs ylthgiN <ht morf gnir<dnaw n<vaR tn<icna dna mirg yltsahG ,n<varc on <rus tra\" ,dias I \",uoht ,n<vahs dna nrohs <b ts<rc yht hguohT\",<row ti <cnan<tnuoc <ht fo muroc<d nr<ts dna <varg <ht yB ,gnilims otni ycnaf das ym gniliug<b drib ynob< siht n<hT");
        //System.out.println(reverseString(text));

        //String text = "Th<n this <bony bird b<guiling my sad fancy into smiling, By th< grav< and st<rn d<corum of th< count<nanc< it wor<,\"Though thy cr<st b< shorn and shav<n, thou,\" I said, \"art sur< no crav<n, Ghastly grim and anci<nt Rav<n wand<ring from th< Nightly shor<— T<ll m< what thy lordly nam< is on th< Night's Plutonian shor<!\" \nQuoth th< Rav<n \"N<v<rmor<.\"\n\nMuch I marv<ll<d this ungainly fowl to h<ar discours< so plainly, Though its answ<r littl< m<aning—littl< r<l<vancy bor<; For w< cannot h<lp agr<<ing that no living human b<ing <v<r y<t was bl<ss<d with s<<ing bird abov< his chamb<r door— Bird or b<ast upon th< sculptur<d bust abov< his chamb<r door, \nWith such nam< as \"N<v<rmor<.\"";
        //System.out.println(replaceCharacter(text, '<', 'e'));

        String text = "Once upon a midnight dreary, while I pondered, weak and weary,Over many a quaint and curious volume of forgotten lore—While I nodded, nearly napping, suddenly there came a tapping,As of some one gently rapping, rapping at my chamber door.\"’Tis some visitor,\" I muttered, \"tapping at my chamber door—\nOnly this and nothing more.\"\n\nAh, distinctly I remember it was in the bleak December;And each separate dying ember wrought its ghost upon the floor. Eagerly I wished the morrow;—vainly I had sought to borrow \nFrom my books surcease of sorrow—sorrow for the lost Lenore—For the rare and radiant maiden whom the angels name Lenore—\nNameless here for evermore.\n\nAnd the silken, sad, uncertain rustling of each purple curtain\nThrilled me—filled me with fantastic terrors never felt before;\nSo that now, to still the beating of my heart, I stood repeating\n\"’Tis some visitor entreating entrance at my chamber door—Some late visitor entreating entrance at my chamber door;—\nThis it is and nothing more.\"\n\nPresently my soul grew stronger; hesitating then no longer,\"Sir,\" said I, \"or Madam, truly your forgiveness I implore; But the fact is I was napping, and so gently you came rapping, And so faintly you came tapping, tapping at my chamber door,That I scarce was sure I heard you\"—here I opened wide the door—\nDarkness there and nothing more.\n\nDeep into that darkness peering, long I stood there wondering, fearing, Doubting, dreaming dreams no mortal ever dared to dream before; But the silence was unbroken, and the stillness gave no token, And the only word there spoken was the whispered word, \"Lenore?\"This I whispered, and an echo murmured back the word, \"Lenore!\"—\nMerely this and nothing more.\n\nBack into the chamber turning, all my soul within me burning, Soon again I heard a tapping somewhat louder than before.\"Surely,\" said I, \"surely that is something at my window lattice;\nLet me see, then, what thereat is, and this mystery explore—Let my heart be still a moment and this mystery explore;—\n’Tis the wind and nothing more!\"\n\nOpen here I flung the shutter, when, with many a flirt and flutter, In there stepped a stately Raven of the saintly days of yore;Not the least obeisance made he; not a minute stopped or stayed he;But, with mien of lord or lady, perched above my chamber door— Perched upon a bust of Pallas just above my chamber door—Perched, and sat, and nothing more.\n\nThen this ebony bird beguiling my sad fancy into smiling,\nBy the grave and stern decorum of the countenance it wore,\"Though thy crest be shorn and shaven, thou,\" I said, \"art sure no craven,Ghastly grim and ancient Raven wandering from the Nightly shore—Tell me what thy lordly name is on the Night’s Plutonian shore!\"\nQuoth the Raven \"Nevermore.\"\n\nMuch I marvelled this ungainly fowl to hear discourse so plainly,Though its answer little meaning—little relevancy bore; For we cannot help agreeing that no living human being Ever yet was blessed with seeing bird above his chamber door—Bird or beast upon the sculptured bust above his chamber door,\nWith such name as \"Nevermore.\"\n\nBut the Raven, sitting lonely on the placid bust, spoke only That one word, as if his soul in that one word he did outpour. Nothing farther then he uttered—not a feather then he fluttered— Till I scarcely more than muttered \"Other friends have flown before—On the morrow he will leave me, as my Hopes have flown before.\"\nThen the bird said \"Nevermore.\"\n\nStartled at the stillness broken by reply so aptly spoken,\"Doubtless,\" said I, \"what it utters is its only stock and storeCaught from some unhappy master whom unmerciful Disaster Followed fast and followed faster till his songs one burden bore— Till the dirges of his Hope that melancholy burden bore Of ‘Never—nevermore’.\"\n\n But the Raven still beguiling all my fancy into smiling, Straight I wheeled a cushioned seat in front of bird, and bust and door; Then, upon the velvet sinking, I betook myself to linking Fancy unto fancy, thinking what this ominous bird of yore— What this grim, ungainly, ghastly, gaunt, and ominous bird of yore\n\nMeant in croaking \"Nevermore.\" This I sat engaged in guessing, but no syllable expressing To the fowl whose fiery eyes now burned into my bosom’s core; This and more I sat divining, with my head at ease reclining On the cushion’s velvet lining that the lamp-light gloated o’er, But whose velvet-violet lining with the lamp-light gloating o’er,\nShe shall press, ah, nevermore!\n\nThen, methought, the air grew denser, perfumed from an unseen censer Swung by Seraphim whose foot-falls tinkled on the tufted floor. \"Wretch,\" I cried, \"thy God hath lent thee—by these angels he hath sent thee Respite—respite and nepenthe from thy memories of Lenore; Quaff, oh quaff this kind nepenthe and forget this lost Lenore!\"\nQuoth the Raven \"Nevermore.\"\n\n\"Prophet!\" said I, \"thing of evil!—prophet still, if bird or devil!—Whether Tempter sent, or whether tempest tossed thee here ashore, Desolate yet all undaunted, on this desert land enchanted— On this home by Horror haunted—tell me truly, I implore—Is there—is there balm in Gilead?—tell me—tell me, I implore!\"\nQuoth the Raven \"Nevermore.\"\n\n\"Prophet!\" said I, \"thing of evil!—prophet still, if bird or devil! By that Heaven that bends above us—by that God we both adore— Tell this soul with sorrow laden if, within the distant Aidenn, It shall clasp a sainted maiden whom the angels name Lenore—Clasp a rare and radiant maiden whom the angels name Lenore.\"\nQuoth the Raven \"Nevermore.\"\n\n\"Be that word our sign of parting, bird or fiend!\" I shrieked, upstarting—\"Get thee back into the tempest and the Night’s Plutonian shore!Leave no black plume as a token of that lie thy soul hath spoken!Leave my loneliness unbroken!—quit the bust above my door!Take thy beak from out my heart, and take thy form from off my door!\"\nQuoth the Raven \"Nevermore.\"\n\nAnd the Raven, never flitting, still is sitting, still is sitting On the pallid bust of Pallas just above my chamber door; And his eyes have all the seeming of a demon’s that is dreaming,And the lamp-light o’er him streaming throws his shadow on the floor;And my soul from out that shadow that lies floating on the floor\nShall be lifted—nevermore!";
        //System.out.println(findNumberOfQuotes(text));
        System.out.println(findNumValues(text, "Nevermore")); //count of 11 is expected.
    }
    
}
