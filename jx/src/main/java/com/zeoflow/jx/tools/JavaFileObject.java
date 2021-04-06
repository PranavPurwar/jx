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

package com.zeoflow.jx.tools;

import com.zeoflow.jx.lang.model.element.Modifier;
import com.zeoflow.jx.lang.model.element.NestingKind;

/**
 * File abstraction for tools operating on Java&trade; programming language
 * source and class files.
 *
 * <p>All methods in this interface might throw a SecurityException if
 * a security exception occurs.
 *
 * <p>Unless explicitly allowed, all methods in this interface might
 * throw a NullPointerException if given a {@code null} argument.
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @see JavaFileManager
 * @since 1.6
 */
public interface JavaFileObject extends FileObject
{

    /**
     * Gets the kind of this file object.
     *
     * @return the kind
     */
    Kind getKind();

    /**
     * Checks if this file object is compatible with the specified
     * simple name and kind.  A simple name is a single identifier
     * (not qualified) as defined in
     * <cite>The Java&trade; Language Specification</cite>,
     * section 6.2 "Names and Identifiers".
     *
     * @param simpleName a simple name of a class
     * @param kind       a kind
     *
     * @return {@code true} if this file object is compatible; false
     * otherwise
     */
    boolean isNameCompatible(String simpleName, Kind kind);
    /**
     * Provides a hint about the nesting level of the class
     * represented by this file object.  This method may return
     * {@link NestingKind#MEMBER} to mean
     * {@link NestingKind#LOCAL} or {@link NestingKind#ANONYMOUS}.
     * If the nesting level is not known or this file object does not
     * represent a class file this method returns {@code null}.
     *
     * @return the nesting kind, or {@code null} if the nesting kind
     * is not known
     */
    NestingKind getNestingKind();
    /**
     * Provides a hint about the access level of the class represented
     * by this file object.  If the access level is not known or if
     * this file object does not represent a class file this method
     * returns {@code null}.
     *
     * @return the access level
     */
    Modifier getAccessLevel();

    /**
     * Kinds of JavaFileObjects.
     */
    enum Kind
    {
        /**
         * Source files written in the Java programming language.  For
         * example, regular files ending with {@code .java}.
         */
        SOURCE(".java"),

        /**
         * Class files for the Java Virtual Machine.  For example,
         * regular files ending with {@code .class}.
         */
        CLASS(".class"),

        /**
         * HTML files.  For example, regular files ending with {@code
         * .html}.
         */
        HTML(".html"),

        /**
         * Any other kind.
         */
        OTHER("");
        /**
         * The extension which (by convention) is normally used for
         * this kind of file object.  If no convention exists, the
         * empty string ({@code ""}) is used.
         */
        public final String extension;
        Kind(String extension)
        {
            extension.getClass(); // null check
            this.extension = extension;
        }
    }

}
