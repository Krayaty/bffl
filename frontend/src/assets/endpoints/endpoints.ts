import {apiUrl} from '../../environments/environment';

export const endpoints = {
  get: {
    calls_of_short_url: `${apiUrl}/api/callsOfShortURL`,
    groups_of_user: `${apiUrl}/api/groupsOfUser`,
    is_user_admin_of_group: `${apiUrl}/api/isUserAdminOfGroup`,
    number_of_url_calls: `${apiUrl}/api/numberOfUrlCalls`,
    possible_tags_for_short_url: `${apiUrl}/api/possibleTagsForShortURL`,
    short_url_by_id: `${apiUrl}/api/shortURLByID`,
    short_urls_by_group: `${apiUrl}/api/shortURLsByGroup`,
    tags_assigned_to_short_url: `${apiUrl}/api/tagsAssignedToShortURL`,
    tags_by_group: `${apiUrl}/api/tagsByGroup`,
    target_assignment_history_for_short_url: `${apiUrl}/api/targetAssignmentHistoryForShortURL`
  },
  post: {
    add_user_as_admin_to_group: `${apiUrl}/api/addUserAsAdminToGroup`,
    add_user_to_group: `${apiUrl}/api/addUserToGroup`,
    assign_tag_to_short_url: `${apiUrl}/api/assignTagToShortURL`,
    assign_target_to_short_url: `${apiUrl}/api/assignTargetToShortURL`,
    create_short_url_for_group_with_tags: `${apiUrl}/api/createShortURLForGroupWithTags`,
    create_group: `${apiUrl}/api/createGroup`,
    deleteGroup: `${apiUrl}/api/deleteGroup`,
    delete_short_url: `${apiUrl}/api/deleteShortURL`,
    delete_tag: `${apiUrl}/api/deleteTag`,
    delete_target_of_short_url: `${apiUrl}/api/deleteTargetOfShortUrl`,
    delete_url_has_tag_assignment: `${apiUrl}/api/deleteUrlHasTagAssignment`,
    delete_user_from_group: `${apiUrl}/api/deleteUserFromGroup`,
    update_delete_flag: `${apiUrl}/api/updateDeleteFlag`,
    update_group_size: `${apiUrl}/api/updateGroupSize`,
    update_short_url: `${apiUrl}/api/updateShortURL`,
    update_tag: `${apiUrl}/api/updateTag`,
    update_update_flag: `${apiUrl}/api/updateUpdateFlag`,
    update_user_of_group_assignment: `${apiUrl}/api/updateUserOfGroupAssignment`,
  }

};
