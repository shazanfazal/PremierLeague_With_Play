import {GET_TEAMS} from '../../../../utils/apiEndPoints'
import instance from '../../../../utils/httpClient'

/**
 * Get All Teams
 * @returns {array}
 */
export const retrieveAllTeams = () => {
    try {
      return(instance.get(GET_TEAMS));
    } catch (exception) {
      console.log(exception);
    }
};
