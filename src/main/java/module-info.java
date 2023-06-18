/**
 * The {@code fr.univartois.cril.juniverse} module provides universal interfaces for
 * solving constraint problems.
 *
 * @uses fr.univartois.cril.juniverse.utils.IUniverseSolverFactory
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */

module fr.univartois.cril.juniverse {

    // Exported packages.

    exports fr.univartois.cril.juniverse.config;

    exports fr.univartois.cril.juniverse.core;

    exports fr.univartois.cril.juniverse.core.problem;

    exports fr.univartois.cril.juniverse.csp;

    exports fr.univartois.cril.juniverse.csp.intension;

    exports fr.univartois.cril.juniverse.csp.operator;

    exports fr.univartois.cril.juniverse.listener;

    exports fr.univartois.cril.juniverse.optim;

    exports fr.univartois.cril.juniverse.pb;

    exports fr.univartois.cril.juniverse.sat;

    exports fr.univartois.cril.juniverse.utils;

    // Solver factories can be easily retrieve when using IUniverseSolverFactory.

    uses fr.univartois.cril.juniverse.utils.IUniverseSolverFactory;

}
