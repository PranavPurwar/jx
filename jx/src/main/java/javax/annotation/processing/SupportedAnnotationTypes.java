/*
 * Copyright (C) 2021 ZeoFlow SRL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.annotation.processing;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation used to indicate what annotation types an annotation
 * processor supports.  The {@link
 * Processor#getSupportedAnnotationTypes} method can construct its
 * result from the value of this annotation, as done by {@link
 * AbstractProcessor#getSupportedAnnotationTypes}.  Only {@linkplain
 * Processor#getSupportedAnnotationTypes strings conforming to the
 * grammar} should be used as values.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface SupportedAnnotationTypes
{

    /**
     * Returns the names of the supported annotation types.
     *
     * @return the names of the supported annotation types
     */
    String[] value();

}
