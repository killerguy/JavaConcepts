package com.mukul.java8features.lambdas.interfaces;

import com.mukul.java8features.lambdas.domain.Patient;

public class InheritanceRules2 {

    /**
     * A patient being operated by a specialist
     */
    interface Surgeon {
        default String operate(Patient p) {
            return "Patient is being operated by a specialist";
        }
    }

    /**
     * A general physician operating a patient
     */
    interface Doctor extends Surgeon {
        default String operate(Patient p) {
            return "Patient is being operated by a general physician";
        }
    }


    /**
     * This class demonstrates that sub-interfaces win during multiple inheritance war.
     */
    public class Hospital implements Doctor, Surgeon {
        /**
         * As Doctor is close to the Hospital in the object graph, it's operate method gets picked up
         *
         * @param p
         * @return
         */
        public String admitAndOperate(Patient p) {
            return operate(p);
        }
    }
}
