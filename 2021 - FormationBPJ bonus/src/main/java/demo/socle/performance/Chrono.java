package demo.socle.performance;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Classe utilitaire pour mesurer laz performance.
 * 
 * @version 20170414
 * 
 * @example No1 - Chrono dans une petite boucle sans observation mémoire
 *          // Utilisation en static
 *          Chrono.startChrono("Traitement No1", System.out);
 *          // Traitement à messurer
 *          // ...
 *          Chrono.stopChrono();
 * @example No2 - Chrono dans différents threads
 *          // Utilisation en instance (multi-thread)
 *          Chrono vChrono = Chrono.newInstance("Traitement No2", System.out);
 *          vChrono.start();
 *          // Traitement à messurer
 *          // ...
 *          vChrono.stop();
 */
public class Chrono {
   private static final Chrono _Instance = new Chrono();

   private String _ChronoName;
   private OutputStream _Out;
   private boolean _IsObserveMemory = false;

   private long _StartTime;
   private long _StopTime;
   private long _DeltaTime;

   private long _StartFreememory;
   private long _StopFreememory;
   private long _DeltaFreememory;

   /**
    * Constructeur privé.
    */
   private Chrono() {
      // RAS
   }

   /**
    * Constructeur privé.
    * 
    * @param pChronoName Le nom du chrono.
    * @param pOut Le flux de sortie.
    */
   private Chrono(String pChronoName, OutputStream pOut, boolean pIsObserveMemory) {
      super();
      resetChrono(pChronoName, pOut, pIsObserveMemory);
   }

   /**
    * Réinitialiser l'instance courante (recyclage).
    * 
    * @param pChronoName Le nom du chrono.
    * @param pOut Le flux de sortie.
    */
   private void resetChrono (String pChronoName, OutputStream pOut, boolean pIsObserveMemory) {
      _ChronoName = pChronoName;
      _Out = pOut;
      _IsObserveMemory = pIsObserveMemory;
      // RAZ
      _StartTime = 0;
      _StopTime = 0;
      _StartFreememory = 0;
      _StopFreememory = 0;
   }

   /**
    * Obtenir une nouvelle instance (contexte multi-thread).
    * 
    * @param pChronoName Le nom du chrono.
    * @param pOut Le flux de sortie.
    * @return Une nouvelle instance.
    */
   public static Chrono newInstance (String pChronoName, OutputStream pOut, boolean pIsObserveMemory) {
      return new Chrono(pChronoName, pOut, pIsObserveMemory);
   }

   public String getChronoName () {
      return _ChronoName;
   }

   public void setChronoName (String pChronoName) {
      _ChronoName = pChronoName;
   }

   public OutputStream getOut () {
      return _Out;
   }

   public void setOut (OutputStream pOut) {
      _Out = pOut;
   }

   /**
    * Démarrer le chrono.
    */
   public void start () {
      _StartTime = System.nanoTime();
      _StartFreememory = (_IsObserveMemory) ? Runtime.getRuntime().freeMemory() : 0;
   }

   /**
    * Arrêter le chrono.
    */
   public void stop () {
      _StopTime = System.nanoTime();
      _StopFreememory = (_IsObserveMemory) ? Runtime.getRuntime().freeMemory() : 0;

      String message = getMessage();
      try {
         if (_Out != null) {
            _Out.write(message.getBytes());
         }
      }
      catch (IOException err) {
         throw new RuntimeException("Problem during write chrono : " + err.getMessage(), err);
      }
   }

   /**
    * Obtenir le delta du temps écoulé : stop-start.
    * 
    * @return La durée.
    * @see #getDeltaTimeChrono()
    */
   public long getDeltaTime () {
      return _DeltaTime;
   }

   /**
    * Obtenir le delta de mémoire consommée : stop-start.
    * 
    * @return Le mémoire consommée.
    * @see #getDeltaFreememoryChrono()
    */
   public long getDeltaFreememory () {
      return _DeltaFreememory;
   }

   /**
    * Obtenir le message affiché à la fin du chrono.
    * 
    * @return Le message désiré.
    * @see #getMessageChrono()
    */
   public String getMessage () {
      String uniteTime;
      _DeltaTime = _StopTime - _StartTime;
      // Si au moins 1 milli-seconde
      if (_DeltaTime > 1000000) {
         uniteTime = "milliSecondes";
         _DeltaTime = _DeltaTime / 1000000;
      }
      else {
         uniteTime = "namoSecondes";
      }

      if (_IsObserveMemory) {
         _DeltaFreememory = _StopFreememory - _StartFreememory;
         return _ChronoName + " - temps = " + _DeltaTime + " " + uniteTime + " - memoire = " + _DeltaFreememory + " octets\n";
      }
      else {
         return _ChronoName + " - temps = " + _DeltaTime + " " + uniteTime + "\n";

      }
   }

   /**
    * Démarrer le chrono sans affichage du résultat dans la console et sans observation de la mémoire.
    * 
    * @param pChronoName Le nom du chrono.
    * @param pOut Le flux de sortie.
    */
   public static void startChrono (String pChronoName) {
      startChrono(pChronoName, null, false);
   }

   /**
    * Démarrer le chrono sans affichage du résultat dans la console.
    * 
    * @param pChronoName Le nom du chrono.
    * @param pOut Le flux de sortie.
    */
   public static void startChrono (String pChronoName, OutputStream pOut) {
      startChrono(pChronoName, pOut, false);
   }

   /**
    * Démarrer le chrono.
    * 
    * @param pChronoName Le nom du chrono.
    * @param pOut Le flux de sortie (dans une grande itération : consomme beaucoup du CPU).
    * @param pIsObserveMemory 'true' Lance l'observation mémoire (consomme du CPU).
    */
   public static void startChrono (String pChronoName, OutputStream pOut, boolean pIsObserveMemory) {
      _Instance.resetChrono(pChronoName, pOut, pIsObserveMemory);
      _Instance.start();
   }

   /**
    * Arrêter le chrono.
    */
   public static void stopChrono () {
      _Instance.stop();
   }

   /**
    * Obtenir le message affiché à la fin du chrono.
    * 
    * @return Le message désiré.
    * @see #getMessage()
    */
   public static String getMessageChrono () {
      return _Instance.getMessage();
   }

   /**
    * Obtenir le delta du temps écoulé : stop-start.
    * 
    * @return La durée.
    * @see #getDeltaTime()
    */
   public static long getDeltaTimeChrono () {
      return _Instance.getDeltaTime();
   }

   /**
    * Obtenir le delta de mémoire consommée : stop-start.
    * 
    * @return Le mémoire consommée.
    * @see #getDeltaFreememory()
    */
   public static long getDeltaFreememoryChrono () {
      return _Instance.getDeltaFreememory();
   }

}
