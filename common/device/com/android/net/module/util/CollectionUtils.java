/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.net.module.util;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.util.SparseArray;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Utilities for {@link Collection} and arrays.
 */
public final class CollectionUtils {
    private CollectionUtils() {}

    /**
     * @return True if the array is null or 0-length.
     */
    public static <T> boolean isEmpty(@Nullable T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Returns an int array from the given Integer list.
     */
    @NonNull
    public static int[] toIntArray(@NonNull Collection<Integer> list) {
        int[] array = new int[list.size()];
        int i = 0;
        for (Integer item : list) {
            array[i] = item;
            i++;
        }
        return array;
    }

    /**
     * Returns a long array from the given long list.
     */
    @NonNull
    public static long[] toLongArray(@NonNull Collection<Long> list) {
        long[] array = new long[list.size()];
        int i = 0;
        for (Long item : list) {
            array[i] = item;
            i++;
        }
        return array;
    }

    /**
     * @return True if there exists at least one element in the sparse array for which
     * condition {@code predicate}
     */
    public static <T> boolean any(@NonNull SparseArray<T> array, @NonNull Predicate<T> predicate) {
        for (int i = 0; i < array.size(); ++i) {
            if (predicate.test(array.valueAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if the array contains the specified value.
     */
    public static boolean contains(@Nullable int[] array, int value) {
        if (array == null) return false;
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if the array contains the specified value.
     */
    public static <T> boolean contains(@Nullable T[] array, @Nullable T value) {
        if (array == null) return false;
        for (T element : array) {
            if (Objects.equals(element, value)) {
                return true;
            }
        }
        return false;
    }
}