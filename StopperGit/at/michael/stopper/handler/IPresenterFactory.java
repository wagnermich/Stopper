package at.michael.stopper.handler;

import java.util.ServiceLoader;
import java.util.function.Function;

public interface IPresenterFactory {

	 /**
     * This method method replaces the standard afterburner dependency
     * injection.
     *
     * @param <T> the type of the presenter
     * @param clazz presenter class containing the default constructor.
     * @param injectionContext a cache of already instantiated and initialized
     * instances.
     * @return a fully initialized presenter with injected dependencies.
     */
    <T> T instantiatePresenter(Class<T> clazz, Function<String, Object> injectionContext);

    /**
     *
     * @return all discovered implementations of PresenterFactory using the
     * {@link java.util.ServiceLoader} mechanism
     */
    static Iterable<IPresenterFactory> discover() {
    	return ServiceLoader.load(IPresenterFactory.class);
    }

	
	
}
