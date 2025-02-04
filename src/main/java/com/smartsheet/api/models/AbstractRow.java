package com.smartsheet.api.models;

/*
 * #[license]
 * Smartsheet SDK for Java
 * %%
 * Copyright (C) 2023 Smartsheet
 * %%
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
 * %[license]
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsheet.api.models.enums.AccessLevel;
import com.smartsheet.api.models.format.Format;

import java.util.Date;
import java.util.List;

public abstract class AbstractRow <TColumn extends Column, TCell extends Cell> extends IdentifiableModel<Long> {
    @Override
    @JsonIgnore(false)
    public Long getId() {
        return super.getId();
    }

    @Override
    @JsonIgnore(false)
    public IdentifiableModel<Long> setId(Long id) {
        super.setId(id);
        return this;
    }

    @JsonIgnore(false)
    public Long getRowId() {
        return super.getId();
    }

    @JsonIgnore(false)
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setRowId(Long id) {
        super.setId(id);
        return (T) this;
    }

    /** Represents the Sheet ID. */
    private Long sheetId;

    /** Represents the row number. */
    private Integer rowNumber;

    /** Represents the parent row number. */
    private Integer parentRowNumber;

    /** Represents the cells for this row. */
    private List<TCell> cells;

    /** Represents the discussions for this row. */
    private List<Discussion> discussions;

    /** Represents the attachments for this row. */
    private List<Attachment> attachments;

    /** Represents the columns for this row. */
    private List<TColumn> columns;

    /** Represents the date and time the row was created. */
    private Date createdAt;

    /** Represents the date and time the row was modified. */
    private Date modifiedAt;

    /** A read-only flag to indicate if the row is expanded or collapsed. */
    private Boolean expanded;

    /** The version number that is incremented every time a sheet is modified. */
    private Integer version;

    /** The user's permissions on the sheet. */
    private AccessLevel accessLevel;

    /** Indicates if the row is locked. Defaults to false **/
    private Boolean locked;

    /** Indicates if the row is locked for the current user. Defaults to false. **/
    private Boolean lockedForUser;

    /** Represents the {@link Format} for this cell.*/
    private Format format;

    /** Represents the parent row ID. */
    private Long parentId;

    /** Represents the sibling row ID*/
    private Long siblingId;

    /** Represents the URL to the row of the sheet*/
    private String permalink;

    /** Indicates if the row is filtered out by a column filter*/
    private Boolean filteredOut;

    /** Indicates if the sheet is a project sheet with dependencies enabled and this row is in the critical path*/
    private Boolean inCriticalPath;

    /** Represents the conditional {@link Format} for this row.*/
    private Format conditionalFormat;

    /** Indicates if the row should be put at the top of the sheet*/
    private Boolean toTop;

    /** Indicates if the row should be put at the bottom of the sheet*/
    private Boolean toBottom;

    /** Indicates if the row should be put above the specified sibling row*/
    private Boolean above;

    /** Indent a row (applicable for update only)*/
    private Integer indent;

    /** Outdent a row (applicable for update only)*/
    private Integer outdent;
    
    /** User object containing name and email of the creator of this row */
    private User createdBy;
    
    /** User object containing name and email of the last person to modify this row */
    private User modifiedBy;

    /**
     * Gets the user's permissions on the sheet.
     *
     * @return the access level
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * Sets the user's permissions on the sheet.
     *
     * @param accessLevel the new access level
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return (T)this;
    }

    /**
     * Gets the version number that is incremented every time a sheet is modified.
     *
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version number that is incremented every time a sheet is modified..
     *
     * @param version the new version
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setVersion(Integer version) {
        this.version = version;
        return (T) this;
    }

    /**
     * Checks if the row is expanded.
     *
     * @return true, if is expanded
     */
    public Boolean isExpanded() {
        return expanded;
    }

    /**
     * Sets the row to be expanded.
     *
     * @param expanded the new expanded
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setExpanded(Boolean expanded) {
        this.expanded = expanded;
        return (T) this;
    }

    /**
     * Get a column by it's index.
     *
     * @param index the column index
     * @return the column by index
     */
    public TColumn getColumnByIndex(int index) {
        if (columns == null) {
            return null;
        }
        return columns.stream().filter(column -> column.getIndex() == index).findFirst().orElse(null);
    }

    /**
     * Get a column by it's ID.
     *
     * @param columnId the column id
     * @return the column by id
     */
    public TColumn getColumnById(long columnId) {
        if (columns == null) {
            return null;
        }
        return columns.stream().filter(column -> column.getId() == columnId).findFirst().orElse(null);
    }

    /**
     * Gets the id of the sheet.
     *
     * @return the sheet id
     */
    public Long getSheetId() {
        return sheetId;
    }

    /**
     * Sets the sheet id.
     *
     * @param sheetId the new sheet id
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setSheetId(Long sheetId) {
        this.sheetId = sheetId;
        return (T) this;
    }

    /**
     * Gets the row number.
     *
     * @return the row number
     */
    public Integer getRowNumber() {
        return rowNumber;
    }

    /**
     * Sets the row number.
     *
     * @param rowNumber the new row number
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
        return (T) this;
    }

    /**
     * Gets the parent row number.
     *
     * @return the parent row number
     */
    public Integer getParentRowNumber() {
        return parentRowNumber;
    }

    /**
     * Sets the parent row number.
     *
     * @param parentRowNumber the new parent row number
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setParentRowNumber(Integer parentRowNumber) {
        this.parentRowNumber = parentRowNumber;
        return (T) this;
    }

    /**
     * Gets the cells.
     *
     * @return the cells
     */
    public List<TCell> getCells() {
        return cells;
    }

    /**
     * Sets the cells.
     *
     * @param cells the new cells
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setCells(List<TCell> cells) {
        this.cells = cells;
        return (T)this;
    }

    /**
     * Gets the discussions.
     *
     * @return the discussions
     */
    public List<Discussion> getDiscussions() {
        return discussions;
    }

    /**
     * Sets the discussions.
     *
     * @param discussions the new discussions
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
        return (T) this;
    }

    /**
     * Gets the attachments.
     *
     * @return the attachments
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * Sets the attachments.
     *
     * @param attachments the new attachments
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        return (T) this;
    }

    /**
     * Gets the columns.
     *
     * @return the columns
     */
    public List<TColumn> getColumns() {
        return columns;
    }

    /**
     * Sets the columns.
     *
     * @param columns the new columns
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setColumns(List<TColumn> columns) {
        this.columns = columns;
        return (T) this;
    }

    /**
     * Gets the date and time a row was created.
     *
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the date and time a row was created.
     *
     * @param createdAt the new created at
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return (T) this;
    }

    /**
     * Gets the date and time a row was modified.
     *
     * @return the modified at
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    /**
     * Sets the date and time a row was modified.
     *
     * @param modifiedAt the new modified at
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return (T) this;
    }

    /**
     * Indicates whether a row is locked or not.
     *
     * @return the locked status
     */
    public Boolean isLocked() {
        return locked;
    }

    /**
     * @param locked the locked status
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setLocked(Boolean locked) {
        this.locked = locked;
        return (T) this;
    }

    /**
     * Indicates whether a row is locked for the user. Users cannot modify rows that are locked for them.
     * @return the lock status for the user
     */
    public Boolean isLockedForUser() {
        return lockedForUser;
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setLockedForUser(Boolean lockedForUser) {
        this.lockedForUser = lockedForUser;
        return (T) this;
    }

    /**
     * @return the {@link Format}
     */
    public Format getFormat() {
        return format;
    }

    /**
     * @param format the {@link Format} to set
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setFormat(Format format) {
        this.format = format;
        return (T) this;
    }

    /**
     * Gets the row's parent ID.
     *
     * @return the ID of the parent
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * Sets the parent row id.
     *
     * @param parentId the parent row id
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setParentId(Long parentId) {
        this.parentId = parentId;
        return (T) this;
    }

    /**
     * Gets the row's sibling ID.
     *
     * @return the ID of the sibling
     */
    public Long getSiblingId() {
        return siblingId;
    }

    /**
     * Sets the sibling row id.
     *
     * @param siblingId the sibling row id
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setSiblingId(Long siblingId) {
        this.siblingId = siblingId;
        return (T) this;
    }

    /**
     * Gets the row's permalink URL.
     *
     * @return the permalink URL of the row
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * Sets the parmalink URL.
     *
     * @param permalink the URL to the row
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setPermalink(String permalink) {
        this.permalink = permalink;
        return (T) this;
    }

    /**
     * Check if the row is filtered out
     *
     * @return true, if it is filtered out
     */
    public Boolean isFilteredOut() {
        return filteredOut;
    }

    /**
     * Sets the row to be filtered out.
     *
     * @param filteredOut if the row is filtered out
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setFilteredOut(Boolean filteredOut) {
        this.filteredOut = filteredOut;
        return (T) this;
    }

    /**
     * Check if the row is in critical path
     *
     * @return true, if it is in critical path
     */
    public Boolean isInCriticalPath() {
        return inCriticalPath;
    }

    /**
     * Sets the row to be in critical path.
     *
     * @param inCriticalPath if the row is in critical path
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setInCriticalPath(Boolean inCriticalPath) {
        this.inCriticalPath = inCriticalPath;
        return (T) this;
    }

    /**
     * @return the conditional {@link Format}
     */
    public Format getConditionalFormat() {
        return conditionalFormat;
    }

    /**
     * Sets the conditional format of the row.
     *
     * @param conditionalFormat the conditional format
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setConditionalFormat(Format conditionalFormat) {
        this.conditionalFormat = conditionalFormat;
        return (T) this;
    }

    /**
     * Gets the to top.
     *
     * @return true, if row should be at the top
     */
    public Boolean getToTop() {
        return toTop;
    }

    /**
     * Sets the to top
     *
     * @param toTop if the row is to the top
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setToTop(Boolean toTop) {
        this.toTop = toTop;
        return (T) this;
    }

    /**
     * Gets the to bottom.
     *
     * @return true, if row should be at the bottom
     */
    public Boolean getToBottom() {
        return toBottom;
    }

    /**
     * Sets the to bottom
     *
     * @param toBottom if the row is to the bottom
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setToBottom(Boolean toBottom) {
        this.toBottom = toBottom;
        return (T) this;
    }

    /**
     * Gets the above.
     *
     * @return true, if row should be above the specified sibling ID
     */
    public Boolean getAbove() {
        return above;
    }

    /**
     * Sets the above
     *
     * @param above if the row is above a specified row
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setAbove(Boolean above) {
        this.above = above;
        return (T) this;
    }

    /**
     * Get integer value specifying the number of levels to indent this row (update only).
     *
     * @return value specifying the number of levels to indent this row
     */
    public Integer getIndent() { return indent; }

    /**
     * Sets integer value specifying the number of levels to indent this row (update only).
     *
     * @param indent integer value specifying the number of levels to indent
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setIndent(Integer indent) {
        this.indent = indent;
        return (T) this;
    }

    /**
     * Get integer value specifying the number of levels to outdent this row (update only).
     *
     * @return value specifying the number of levels to outdent this row
     */
    public Integer getOutdent() { return outdent; }

    /**
     * Sets integer value specifying the number of levels to outdent this row (update only).
     *
     * @param outdent integer value specifying number of levels to outdent
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractRow<TColumn, TCell>> T setOutdent(Integer outdent) {
        this.outdent = outdent;
        return (T) this;
    }

    /**
     * Gets the User object containing name and email of the creator of this row.
     *
     * @return User object
     */    
    public User getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Gets the User object containing name and email of the last person to modify this row.
     *
     * @return User object
     */     
    public User getModifiedBy() {
        return modifiedBy;
    }
}
