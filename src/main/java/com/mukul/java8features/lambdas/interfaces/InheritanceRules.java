package com.mukul.java8features.lambdas.interfaces;


import com.mukul.java8features.lambdas.domain.Patient;

public class InheritanceRules {

    /**
     * A general physician operating a patient
     */
    interface Doctor {
        default String operate(Patient p) {
            return "Patient is being operated by a general physician";
        }
    }

    /**
     * A patient being operated by a specialist
     */
    interface Surgeon {
        default String operate(Patient p) {
            return "Patient is being operated by a specialist";
        }
    }

    /**
     * This class compilation fails as compiler is thoroughly confused as to whose method it shoudl pick
     *
     *
     */
//	class Hospital implements Doctor, Surgeon{
//		private String admitAndOperate(Patient p){
//			return operate(p);
//		}
//	}

    /**
     * Create a method to provide the specific logic
     */
    class Hospital1 implements Doctor, Surgeon {
        // Overriding with own implementation
        public String operate(Patient p) {
            return "Patient operated";
        }
    }

    /**
     * If we wish to grab one of the interface's implementations, use super keyword
     */
    class Hospital2 implements Doctor, Surgeon {
        public String operate(Patient p) {
            return Doctor.super.operate(p);
        }
    }
}
